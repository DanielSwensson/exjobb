-module(writer).
-export([write/1,write_from_file/1,close/0,run/1]).

write(Data) ->  
  writer ! {write, Data}.

write_from_file(File) ->
  writer ! {write_from_file,File}.

close() -> writer ! {close}.

run(FileName) ->
  register(writer,spawn(fun() -> 
    {ok, IO} = file:open(FileName,[write,raw]),
    writer(IO) 
  end)).
  

writer(IO) ->
  receive 
    {write, Data} ->
      ok = file:write(IO, Data),
      writer(IO);
    {write_from_file, File} ->
         {ok,Data} = file:read_file(File),
         ok = file:write(IO,binary_to_list(Data)),
         writer(IO);
    {close} ->
      file:close(IO),
      unregister(writer)
  end.