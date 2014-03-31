-module(checkstyle).
-export([run/1]).


save_to_file({Results,NrLines}) ->
  ResultsList = dict:to_list(Results),
  % R = io_lib:format("~p",[ResultsList]),
  % R1 = lists:flatten(R),
  {ok, IO} = file:open("results.html",[write,raw]),
  file:write(IO, "<h1> Results </h1>\n"),
  file:write(IO, "<b> Lines of code: " ++ integer_to_list(NrLines) ++ "</b>\n"),
  file:write(IO, "<ul>\n"),
  write_list(ResultsList, IO),
  file:write(IO, "</ul>\n"),
  file:close(IO),
  % file:write_file("results", R1 ),
  io:format("DONE! file 'results' written ~n").

write_list([], _IO) ->
  ok;
write_list([{ErrorType, Freq}| T], IO) ->
  file:write(IO, "<li>" ++ [ErrorType] ++ " | <b>" ++ integer_to_list(Freq) ++ "</b></li>\n"),
  write_list(T,IO).


run(Dir) -> 
  S = self(),
  spawn(fun() -> S ! count_lines:count(Dir) end),
  io:format("Running CheckStyle on ~p ~n",[self()]),
  Res = os:cmd("java -jar checkstyle/checkstyle-5.7-all.jar -c checkstyle/sun_checks.xml -r " ++ Dir ++ "*.java" ++  " -f xml"),
  io:format("CheckStyle completed ~n"),
  Results = analyze(Res),
  NrLines =
  receive 
    Any -> Any
  end,
  save_to_file({Results,NrLines}).

analyze(Res) ->
  io:format("Analyzing results ~n"),
  Reg = "source=\"com\.puppycrawl\.tools\.checkstyle\.checks\.(?<ERR>.+)\"",
  {match,Results} = re:run(Res,Reg,[global,{capture,['ERR'],list}]),
 reg(Results,dict:new()).

reg([],Res) -> Res;
reg([[H]|T],Res) -> 
  case dict:is_key(H,Res) of
    true ->
      reg(T,dict:update(H,fun(Val) -> Val+1 end, Res));
    false ->
      reg(T,dict:store(H,1,Res))
  end.



