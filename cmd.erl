-module(cmd).
-export([run/0]).

run() -> 
os:cmd("java -jar checkstyle/checkstyle-5.7-all.jar -c checkstyle/sun_checks.xml -r oop/src/*.java -o test.xml -f xml"),
{ok,Binary}=file:read_file("test.xml"),
% io:format("~p",[ParsResult]),
F = binary_to_list(Binary),
Results = extract(F,dict:new()),
io:format("~p", [dict:to_list(Results)]).


% erlang:display(F).
% R = io_lib:format("~p",[ParsResult]),
% R1 = lists:flatten(R),
% ok = file:write_file("parsed",list_to_binary(R1)).

source() -> $s,$o,$u,$r,$c,$e,$=,$";


extract([],Results) -> Results;

extract([source()|T],Results)  ->
     {T1, Result} = getSource(T,[]), 
      Results1 = 
        case dict:is_key(Result,Results) of 
        true ->
          dict:update(Result,fun(Val) -> Val + 1 end, Results);
       false ->
          dict:store(Result,1,Results)
        end,
     extract(T1,Results1);
extract([_H|T],Results) ->
  extract(T,Results).

getSource([$"|T],R) ->
  {T,R};

getSource([H|T],R) ->
  R1 = R ++ [H],
  getSource(T,R1).


