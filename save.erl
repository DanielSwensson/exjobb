-module(save).
-export([save_to_file/2]).


save_to_file({Results,NrLines},FileName) ->
  ResultsList = dict:to_list(Results),
  % R = io_lib:format("~p",[ResultsList]),
  % R1 = lists:flatten(R),
  {ok, IO} = file:open(FileName,[write,raw]),
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
