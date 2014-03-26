-module(cmd).
-export([run/0]).

run() -> 
os:cmd("java -jar checkstyle/checkstyle-5.7-all.jar -c checkstyle/sun_checks.xml -r oop/src/*.java -o test.xml -f xml"),
{ok,Binary}=file:read_file("test.xml"),
% io:format("~p",[ParsResult]),
F = binary_to_list(Binary),
Results = extract(F,dict:new()),
ResultsList = dict:to_list(Results),
R = io_lib:format("~p",[ResultsList]),
R1 = lists:flatten(R),
file:write_file("results", R1 ).




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


