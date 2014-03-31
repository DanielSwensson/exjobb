-module(stddiv).
-export([average/1,run/1]).

% Standardavvikelsen är roten ur medelvärdet av kvadraterna av differensen
% mellan varje datapunkt mot medelvärdet
% res = [v1, v2, v3, ..., vn] % data

% avg1 = average(res) % medelvärde av värden lagrad i avg1
% delt = diff(res,avg1) % differensen mellan värden i res med medelvärdet i avg1 lagrad i delt
% dsqr = square(delt) % kvadraten av varje differens lagrad i delt.
% avg2 = average(dsqr) % medelvärdet äv kvadraterna lagrad i avg2
% stddiv = sqroot(avg2) % standardavvikelsen är roten av medelvärdet

average(L) ->
	lists:sum(L)/length(L).
	
delta(L,Avg) ->
	[X-Avg || X <- L].
	
square_list(L) -> 
	[math:pow(X,2) || X <- L].

run(L) -> 
	Avg1 = average(L),
	Delt  = delta(L,Avg1),
	Sqrd = square_list(Delt),
	Avg2 = average(Sqrd),
	math:sqrt(Avg2).
	