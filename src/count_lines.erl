%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Counts total number of uncommented java code lines in the given directory%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
-module(count_lines).
-export([count/1]).

count(Dir) ->
  {ok, Filenames} = file:list_dir(Dir),
  count_for_each_file(Filenames,Dir,{0,0}).

count_for_each_file([],_Dir,{Total,Comments}) -> {Total,Comments};
count_for_each_file([File | Files],Dir,{Total,Comments}) ->
  case filename:extension(File) of 
    ".java" ->
        {ok,Binary} = file:read_file(Dir ++ File),
        FileString = binary_to_list(Binary),
		{Lines, CommentLines} = count_lines(FileString,0,0,false,false),
        Total1 = Total + Lines,
		Comments1 = Comments + CommentLines,
         count_for_each_file(Files,Dir,{Total1,Comments1});
    _Else ->
      count_for_each_file(Files,Dir,{Total,Comments})
    end.
count_lines([], Lines,Comments,_Comment,_BlockComment) -> {Lines,Comments};

count_lines([$\n|L],Lines,Comments,Comment,BlockComment) ->
 case Comment of 
 	true ->
 		count_lines(L, Lines,Comments,false,BlockComment);
 	false	->
 		case BlockComment of 
 			true ->
 				count_lines(L, Lines,Comments+1, false, BlockComment);
 			false ->
 				count_lines(L, Lines + 1,Comments,false,false)
 		end  		
  end;

 count_lines([$/,$/|L], Lines,Comments, _Comment,BlockComment) ->
 	count_lines(L,Lines,Comments,true,BlockComment);

 count_lines([$/,$*|L], Lines,Comments, Comment,_BlockComment) ->
 	count_lines(L,Lines,Comments,Comment,true);

  count_lines([$*,$/|L], Lines,Comments, Comment,_BlockComment) ->
 	count_lines(L,Lines,Comments,Comment,false);

count_lines([_H|T], Lines,Comments,Comment,BlockComment) -> count_lines(T, Lines,Comments,Comment,BlockComment).