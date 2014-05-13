-module(save).
-export([save_to_file/6]).
-import(writer,[write/1]).

save_backup(Results, Count, Stddiv,FileName) ->
  Backup = term_to_binary({Results, Count, Stddiv}),
  file:write_file("Backup_" ++ FileName , Backup).

save_to_file(Results,Count,Stddiv,NrLines , AverageComments ,FileName) ->
  writer:run(FileName ++ ".html"),
  save_backup(Results, Count, Stddiv,FileName),
  write("<!doctype html>\n"),
  write("<html>\n"),
  write("<head>\n"),
  write("<link href='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css' rel='stylesheet'>\n"),
  write("<link href='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css' rel='stylesheet'>\n"),
  write("<title>Resultat</title>\n"),
  write("</head>\n"),
  write("<body>\n"),

  write("<div class='container'>\n"),

  write("<h4 class='page-header'> Resultat </h4>"),
  
  write("<p><small> Antal studenter: " ++ integer_to_list(Count) ++ "</small></p>\n"),
  write("<p><small> Medelvärde för antal kommentarer per elev: " ++ io_lib:format("~.7f",[AverageComments / Count]) ++ "</small></p>\n"),
  write("<p><small> Medelvärde för rader kod per elev: " ++ io_lib:format("~.7f",[NrLines/Count]) ++ "</small></p>\n"),
  write("<div class='row'>"),

  write("<h2> Värden </h2>\n"),
  
  write_stddiv(Stddiv),

  write("</div>"),
  write("<div class='row'>"),
  write("<h2> Individuella resultat </h2>\n"),
  write_result_per_student(Results),
  write("</div>"),
  write("</div>\n"),
  write("</body>\n"),
  write("</html>\n"),
  writer:close(),
  io:format("DONE! file ~p written ~n",[FileName]).

write_result_per_student([]) -> ok;
write_result_per_student([Result | Results]) ->
  {Errors, NrLines,NrComments, Name,_} = Result,
   write("<div class='col-md-4'>\n"),
  write("<h3> "++ Name ++ " "),
  write("<small> Lines of code: " ++ integer_to_list(NrLines)),
  write(" Comment lines: " ++ integer_to_list(NrComments) ++ "</small></h3>\n"),
  
  ResultsList = dict:to_list(Errors),
  write_list(ResultsList),
  write("</div>\n"),
  write_result_per_student(Results).

write_list([]) -> ok;
write_list([{ErrorType, Freq}| T]) ->
 
  write("<h6>" ++ [ErrorType] ++ ": <small>" ++ integer_to_list(Freq) ++ "</small></h6>\n"),
  
  write_list(T).

write_stddiv([]) -> ok;
write_stddiv([{Type, AverageList} | Averages]) ->
  {MedelVarde, Avvikelse} = stddiv:run(AverageList),
  write("<div class='col-md-4'>\n"),
  write("<h5>" ++ [Type] ++ "</h5> \n <p>Avvikelse: " ++ io_lib:format("~.7f",[Avvikelse]) ++ "<br>" ++ " Medelvärde: " ++ io_lib:format("~.7f",[MedelVarde]) ++  "</p>\n"),
  write("</div>\n"),
  write_stddiv(Averages).


