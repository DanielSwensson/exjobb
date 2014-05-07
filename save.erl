-module(save).
-export([save_to_file/4]).


save_to_file(Results,Count,Stddiv,FileName) ->
  {ok, IO} = file:open(FileName,[write,raw]),
  file:write(IO, "<h1> Resultat </h1>\n"),

  file:write(IO, "<b> Antal studenter: " ++ integer_to_list(Count) ++ "</b>\n"),

  file:write(IO, "<h2> Värden </h2>\n"),
  file:write(IO, "<ul>\n"),
  write_stddiv(Stddiv, IO),
  file:write(IO, "</ul>\n"),

  write_result_per_student(Results,IO),
  file:close(IO),
  io:format("DONE! file ~p written ~n",[FileName]).

write_result_per_student([],_) -> ok;
write_result_per_student([Result | Results],IO) ->
  {Errors, NrLines, Name} = Result,
  file:write(IO, "<h4> "++ Name ++ "</h4>\n"),
  file:write(IO, "<b> Lines of code: " ++ integer_to_list(NrLines) ++ "</b>\n"),
  file:write(IO, "<ul>\n"),
  ResultsList = dict:to_list(Errors),
  write_list(ResultsList, IO),
  file:write(IO, "</ul>\n"),
  write_result_per_student(Results,IO).

write_list([], _IO) ->
  ok;
write_list([{ErrorType, Freq}| T], IO) ->
  file:write(IO, "<li>" ++ [ErrorType] ++ " = <b>" ++ integer_to_list(Freq) ++ "</b></li>\n"),
  write_list(T,IO).

write_stddiv([],_) -> ok;
write_stddiv([{Type, AverageList} | Averages],IO) ->
  {MedelVarde, Avvikelse} = stddiv:run(AverageList),
  file:write(IO, "<li><h4>" ++ [Type] ++ "</h4>Avvikelse: " ++ io_lib:format("~.7f",[Avvikelse]) ++ "<br>" ++ " Medelvärde: " ++ io_lib:format("~.7f",[MedelVarde]) ++  "</li>\n"),
  write_stddiv(Averages, IO).
