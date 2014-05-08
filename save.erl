-module(save).
-export([save_to_file/4]).

save_backup(Results, Count, Stddiv,FileName) ->
  Backup = term_to_binary({Results, Count, Stddiv}),
  file:write_file("Backup_" ++ FileName , Backup).

save_to_file(Results,Count,Stddiv,FileName) ->
  
  writer:run(FileName ++ ".html"),
  save_backup(Results, Count, Stddiv,FileName),
  


  writer:write("<h1> Resultat </h1>\n"),

  writer:write("<b> Antal studenter: " ++ integer_to_list(Count) ++ "</b>\n"),

  writer:write("<h2> Värden </h2>\n"),
  writer:write("<ul>\n"),
  write_stddiv(Stddiv),
  writer:write("</ul>\n"),

  write_result_per_student(Results),
  writer:close(),
  io:format("DONE! file ~p written ~n",[FileName]).

write_result_per_student([]) -> ok;
write_result_per_student([Result | Results]) ->
  {Errors, NrLines,NrComments, Name} = Result,
  writer:write("<h4> "++ Name ++ "</h4>\n"),
  writer:write("<b> Lines of code: " ++ integer_to_list(NrLines) ++ "</b><br>\n"),
  writer:write("<b> Comment lines: " ++ integer_to_list(NrComments) ++ "</b>\n"),
  writer:write("<ul>\n"),
  ResultsList = dict:to_list(Errors),
  write_list(ResultsList),
  writer:write("</ul>\n"),
  write_result_per_student(Results).

write_list([]) ->
  ok;
write_list([{ErrorType, Freq}| T]) ->
  writer:write("<li>" ++ [ErrorType] ++ " = <b>" ++ integer_to_list(Freq) ++ "</b></li>\n"),
  write_list(T).

write_stddiv([]) -> ok;
write_stddiv([{Type, AverageList} | Averages]) ->
  {MedelVarde, Avvikelse} = stddiv:run(AverageList),
  writer:write("<li><h4>" ++ [Type] ++ "</h4>Avvikelse: " ++ io_lib:format("~.7f",[Avvikelse]) ++ "<br>" ++ " Medelvärde: " ++ io_lib:format("~.7f",[MedelVarde]) ++  "</li>\n"),
  write_stddiv(Averages).


