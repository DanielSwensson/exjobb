-module(cmd).
-export([run/1,start/1]).

start(Dir) ->
  io:format("Starting ~n"),
  {ok, Filenames} = file:list_dir(Dir),
  Pids = spawn_checks(Filenames,Dir,[]),
  Results = waitForResults(Pids,dict:new()),
  save_to_file(Results).

save_to_file(Results) ->
  ResultsList = dict:to_list(Results),
  R = io_lib:format("~p",[ResultsList]),
  R1 = lists:flatten(R),
  file:write_file("results", R1 ),
  io:format("DONE! file 'results' written ~n").

spawn_checks([],_,Pids) ->
  Pids;
spawn_checks([H|T],Dir,Pids) ->
  Self = self(),
  case filename:extension(H) of 
    ".java" ->
      Pids1 = Pids ++ [spawn(fun() -> Self ! {self(), run(Dir ++ H)} end)],
      % io:format("Starting ~p ~n",[Pids1]),
      spawn_checks(T,Dir,Pids1);
    _Else ->
      spawn_checks(T,Dir,Pids)
  end.

waitForResults([],Results) -> Results;
waitForResults([Pid|T],Results) ->
  receive 
    {Pid, Result} ->
      io:format("Received results from ~p ~n",[Pid]),
      Results1 = merge(dict:to_list(Result),Results),
      waitForResults(T,Results1)
  end.


merge([], Results) -> Results;
merge([{Result, Freq}| T],Results) ->
  Results1 = 
  case dict:is_key(Result,Results) of
    true ->
       dict:update(Result,fun(Val) -> Val + Freq end, Results);
    false ->
        dict:store(Result,Freq,Results)
  end,
  merge(T,Results1).


run(File) -> 

io:format("Running CheckStyle on ~p ~n",[self()]),
XML = os:cmd("java -jar checkstyle/checkstyle-5.7-all.jar -c checkstyle/sun_checks.xml -r " ++ File ++  " -f xml"),
io:format("CheckStyle completed ~n"),
io:format("Analyzing results ~n"),
extract(XML,dict:new()).





extract([],Results) -> Results;

extract([$s,$o,$u,$r,$c,$e,$=,$"|T],Results)  ->
     {T1, Result} = getSource(T,[]), 
      Results1 = 
        case dict:is_key(Result,Results) of 
        true ->
          dict:update(Result,fun(Val) -> Val + 1 end, Results);
       false ->
          dict:store(Result,1,Results)
        end,
     extract(T1,Results1);
extract([_H|T],Results) ->
  extract(T,Results).

getSource([$"|T],R) ->
  {T,R};

getSource([H|T],R) ->
  R1 = R ++ [H],
  getSource(T,R1).


