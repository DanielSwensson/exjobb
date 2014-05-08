-module(save).
-export([save_to_file/4]).

save_backup(Results, Count, Stddiv,FileName) ->
  Backup = term_to_binary({Results, Count, Stddiv}),
  file:write_file("Backup_" ++ FileName , Backup).

save_to_file(Results,Count,Stddiv,FileName) ->
  {ok, IO} = file:open(FileName ++ ".html",[write,raw]),

  register(writer, spawn(fun() -> writer(IO) end)),
  save_backup(Results, Count, Stddiv,FileName),
  


  write("<h1> Resultat </h1>\n"),

  write("<b> Antal studenter: " ++ integer_to_list(Count) ++ "</b>\n"),

  write("<h2> Värden </h2>\n"),
  write("<ul>\n"),
  write_stddiv(Stddiv),
  write("</ul>\n"),

  write_result_per_student(Results),
  close(),
  io:format("DONE! file ~p written ~n",[FileName]).

write_result_per_student([]) -> ok;
write_result_per_student([Result | Results]) ->
  {Errors, NrLines, Name} = Result,
  write("<h4> "++ Name ++ "</h4>\n"),
  write("<b> Lines of code: " ++ integer_to_list(NrLines) ++ "</b>\n"),
  write("<ul>\n"),
  ResultsList = dict:to_list(Errors),
  write_list(ResultsList),
  write("</ul>\n"),
  write_result_per_student(Results).

write_list([]) ->
  ok;
write_list([{ErrorType, Freq}| T]) ->
  write("<li>" ++ [ErrorType] ++ " = <b>" ++ integer_to_list(Freq) ++ "</b></li>\n"),
  write_list(T).

write_stddiv([]) -> ok;
write_stddiv([{Type, AverageList} | Averages]) ->
  {MedelVarde, Avvikelse} = stddiv:run(AverageList),
  write("<li><h4>" ++ [Type] ++ "</h4>Avvikelse: " ++ io_lib:format("~.7f",[Avvikelse]) ++ "<br>" ++ " Medelvärde: " ++ io_lib:format("~.7f",[MedelVarde]) ++  "</li>\n"),
  write_stddiv(Averages).

write(Data) ->  
  writer ! {write, Data}.

close() -> writer ! {close}.

writer(IO) ->
  receive 
    {write, Data} ->
      erlang:display("write"),
      file:write(IO, Data),
      writer(IO);
    {close} ->
      file:close(IO),
      unregister(writer)
  end.