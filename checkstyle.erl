%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Runs checkstyle on all files in given directory.                        % 
%All uncommented lines are counted and results are saved to results.html %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
-module(checkstyle).
-export([run/1,test/0]).

test() ->
  run("./testcode/").

run(Dir) -> 
  {ok, Count, Results,AverageComments,NrLines} = run_per_dir(Dir),
  Stddiv = analyze:get_stddiv(Results,Count),
  save:save_to_file(Results,Count, Stddiv, NrLines , AverageComments ,"results").

run_per_dir(Dir) ->
    {ok,Filenames} = file:list_dir(Dir),
    run_per_dir(Dir,Filenames,0,[],0,0).

run_per_dir(_,[],Count,Res,AverageComents,NrLines) -> {ok, Count, Res,AverageComents,NrLines};
run_per_dir(Dir, [DirName|Filenames],Count, Res, AverageComents,NrLines) ->
  PathDir = Dir ++ DirName,
  case filelib:is_dir(PathDir) of 
    true ->
      Result = run_checkstyle(DirName,PathDir),
      {_,NrLines1,_,_,AverageComments1} = Result,

      Res1 = Res ++ [Result],
      run_per_dir(Dir, Filenames,Count + 1,Res1,AverageComments1 + AverageComents,NrLines + NrLines1);
    false ->
      run_per_dir(Dir, Filenames,Count,Res,AverageComents,NrLines)
  end.
 
run_checkstyle(DirName,Path) ->
  {NrLines,NrComments} = count_lines:count(Path ++ "/"),
  io:format("Running Checkstyle at ~p ~n", [Path]),
  Checkstyle = os:cmd("java -jar checkstyle/checkstyle-5.7-all.jar -c checkstyle/sun_checks.xml -r " ++ Path ++ "/*.java" ++  " -f xml"),
  io:format("CheckStyle on ~p completed ~n", [Path]),
  io:format("Analyzing results on ~p ~n", [Path]),
  Results = analyze:get_error_frequency(Checkstyle),
  % Res1 = dict:store("Rader_kod",NrLines,dict:store("Kommentarer",NrComments,Results)),
  {Results, NrLines,NrComments, DirName,NrComments / NrLines}.








