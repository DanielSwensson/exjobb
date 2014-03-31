-module(checkstyle).
-export([run/1]).



run(Dir) -> 
  S = self(),
  spawn(fun() -> S ! count_lines:count(Dir) end),
  io:format("Running CheckStyle on ~p ~n",[self()]),
  Res = os:cmd("java -jar checkstyle/checkstyle-5.7-all.jar -c checkstyle/sun_checks.xml -r " ++ Dir ++ "*.java" ++  " -f xml"),
  io:format("CheckStyle completed ~n"),
  io:format("Counting results ~n"),
  Results = count(Res),
  io:format("Analyzing results ~n"),
  Results1 = analyze(Results,dict:new()),
  NrLines =
  receive 
    Any -> Any
  end,
  save:save_to_file({Results1,NrLines},"results.html").

count(Res) ->
  Reg = "source=\"com\.puppycrawl\.tools\.checkstyle\.checks\.(?<ERR>.+)\"",
  {match,Results} = re:run(Res,Reg,[global,{capture,['ERR'],list}]),
  Results.


analyze([],Res) -> Res;
analyze([[H]|T],Res) -> 
  case dict:is_key(H,Res) of
    true ->
      analyze(T,dict:update(H,fun(Val) -> Val+1 end, Res));
    false ->
      analyze(T,dict:store(H,1,Res))
  end.



