%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Runs checkstyle on all files in given directory.                        % 
%All uncommented lines are counted and results are saved to results.html %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
-module(checkstyle).
-export([run/1]).



run(Dir) -> 
  {ok, Count, Results} = run_per_dir(Dir),
  save:save_to_file(Results,Count, "results.html").
  % io:format("Count: ~p ~n ~p ~n", [Count,Res]).


run_per_dir(Dir) ->
    {ok,Filenames} = file:list_dir(Dir),
    run_per_dir(Dir,Filenames,0,[]).

run_per_dir(_,[],Count,Res) -> {ok, Count, Res};
run_per_dir(Dir, [DirName|Filenames],Count, Res) ->
  PathDir = Dir ++ DirName,
  case filelib:is_dir(PathDir) of 
    true ->
      Res1 = Res ++ run_checkstyle(DirName,PathDir),
      run_per_dir(Dir, Filenames,Count + 1,Res1);
    false ->
      run_per_dir(Dir, Filenames,Count,Res)
  end.
 


run_checkstyle(DirName,Path) ->
  NrLines = count_lines:count(Path ++ "/"),
  io:format("Running Checkstyle at ~p ~n", [Path]),
  Checkstyle = os:cmd("java -jar checkstyle/checkstyle-5.7-all.jar -c checkstyle/sun_checks.xml -r " ++ Path ++ "/*.java" ++  " -f xml"),
  io:format("CheckStyle on ~p completed ~n", [Path]),
  io:format("Counting results ~n"),
  Results = regex(Checkstyle),
  io:format("Analyzing results on ~p ~n", [Path]),
  Results1 = analyze(Results,dict:new()),
  [{Results1, NrLines, DirName}].
  % save:save_to_file({Results1,NrLines},DirName ++ ".html").



regex(Res) ->
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



