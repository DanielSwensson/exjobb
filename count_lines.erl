%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Counts total number of uncommented java code lines in the given directory%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
-module(count_lines).
-export([count/1]).

count(Dir) ->
  {ok, Filenames} = file:list_dir(Dir),
  count_for_each_file(Filenames,Dir,0).

count_for_each_file([],_Dir,Total) -> Total;
count_for_each_file([File | Files],Dir,Total) ->
  case filename:extension(File) of 
    ".java" ->
        {ok,Binary} = file:read_file(Dir ++ File),
        FileString = binary_to_list(Binary),
        Total1 = Total +  count_lines(FileString,0,false,false),
       
         count_for_each_file(Files,Dir,Total1);
    _Else ->
      count_for_each_file(Files,Dir,Total)
    end.
count_lines([], Lines,_Comment,_BlockComment) -> Lines;

count_lines([$\n|L],Lines,Comment,BlockComment) ->
 case Comment of 
 	true ->
 		count_lines(L, Lines,false,BlockComment);
 	false	->
 		case BlockComment of 
 			true ->
 				count_lines(L, Lines, false, BlockComment);
 			false ->
 				count_lines(L, Lines + 1,false,false)
 		end  		
  end;

 count_lines([$/,$/|L], Lines, _Comment,BlockComment) ->
 	count_lines(L,Lines,true,BlockComment);

 count_lines([$/,$*|L], Lines, Comment,_BlockComment) ->
 	count_lines(L,Lines,Comment,true);

  count_lines([$*,$/|L], Lines, Comment,_BlockComment) ->
 	count_lines(L,Lines,Comment,false);

count_lines([_H|T], Lines,Comment,BlockComment) -> count_lines(T, Lines,Comment,BlockComment).