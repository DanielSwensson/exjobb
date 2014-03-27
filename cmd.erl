-module(cmd).
-export([run/0]).

run() ->
	Res = os:cmd("java -jar D:/checkstyle/checkstyle-5.7-all.jar -c D:/checkstyle/sun_checks.xml -r oop/src/*.java -f xml"),
	%Results = extract(Res,dict:new()),
	Reg = "source=\"com\.puppycrawl\.tools\.checkstyle\.checks\.(?<ERR>.+)\"",
	{match,Results} = re:run(Res,Reg,[global,{capture,['ERR'],list}]),
	Result = reg(Results,dict:new()),
	io:format("~p~n",[dict:to_list(Result)]).
	%io:format("~p~n",[Results]).
	
	%io:format("~p", [dict:to_list(Results)]).


% erlang:display(F).
% R = io_lib:format("~p",[ParsResult]),
% R1 = lists:flatten(R),
% ok = file:write_file("parsed",list_to_binary(R1)).

reg([],Res) -> Res;
reg([[H]|T],Res) -> 
	case dict:is_key(H,Res) of
		true ->
			reg(T,dict:update(H,fun(Val) -> Val+1 end, Res));
		false ->
			reg(T,dict:store(H,1,Res))
	end.


extract([],Results) -> Results;

extract([ $s,$o,$u,$r,$c,$e,$=,$"|T],Results)  ->
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


