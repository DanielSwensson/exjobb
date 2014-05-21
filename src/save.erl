-module(save).
-export([save_to_file/2]).
-import(writer,[write/1]).
-import(writer,[write_from_file/1]).

save_backup(FileName,TupleToSave) ->
  Backup = term_to_binary(TupleToSave),
  file:write_file("results/Backup_" ++ FileName , Backup).

save_to_file({Results,Count,Stddiv,NrLines, AverageComments ,FileName},true) ->
     save_backup(FileName,{Results,Count,Stddiv, NrLines, AverageComments, FileName}),
     save_to_file({Results,Count,Stddiv,NrLines, AverageComments ,FileName},false);

save_to_file({Results,Count,Stddiv,NrLines, AverageComments ,FileName},false) ->
  file:make_dir("results"),
  writer:run("results/" ++ FileName ++ ".html"),

  Data = [{count, Count}, {averageComments , io_lib:format("~.7f",[AverageComments / Count])}, {averageRows, io_lib:format("~.7f",[NrLines/Count])}],
  {ok, Compiled} = sgte:compile_file("template/template.html"),

  Data1 = [{resultsPerStudent, format_result_per_student(Results)}] ++ [{allErrors, format_allErrors(Stddiv)}] ++ Data,

  write(sgte:render_str(Compiled, Data1)), 
  writer:close(),
  io:format("DONE! file ~p written ~n",[FileName]).

format_result_per_student(Results) ->
  lists:map(
    fun(Result) ->
      {Errors, NrLines,NrComments, Name,_} = Result,
      Errors1 = format_errorfreq(dict:to_list(Errors)),
      [{result, [{errors,Errors1},{name,Name}, {nrLines,NrLines},{nrComments, NrComments}]}] 
    end,
    Results
  ).
  

format_errorfreq(Errors) ->
  lists:map(
    fun({ErrorType,Freq}) ->
        [{error,[{errorType, ErrorType},{freq,Freq}]}]
    end,Errors).


format_allErrors(Errors) ->
  lists:map(
    fun({Type, AverageList}) ->
      {MedelVarde, Avvikelse} = stddiv:run(AverageList),
      [{error,[{type,Type},{avvikelse,io_lib:format("~.7f",[Avvikelse])},{medelvarde,io_lib:format("~.7f",[MedelVarde])}]}]
    end,
    Errors
  ).


