-module(save).
-export([save_to_file/3]).


save_to_file(Results,Count,FileName) ->
  {ok, IO} = file:open(FileName,[write,raw]),
  file:write(IO, "<h1> Results </h1>\n"),
  file:write(IO, "<b> Total number of students: " ++ integer_to_list(Count) ++ "</b>\n"),
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
  file:write(IO, "<li>" ++ [ErrorType] ++ " | <b>" ++ integer_to_list(Freq) ++ "</b></li>\n"),
  write_list(T,IO).
