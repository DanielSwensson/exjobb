-module(cmd).
-export([run/0]).

run() -> 
os:cmd("java -jar checkstyle/checkstyle-5.7-all.jar -c checkstyle/sun_checks.xml -r oop/src/*.java -o test.xml -f xml"),
{ParsResult,_Misc}=xmerl_scan:file("test.xml"),
io:format("~p",[ParsResult]).
% L = lists:reverse(extract(ParsResult, [])),
%      % print channel title and data for first two episodes
%      io:format("~n>> ~p~n", [element(1,lists:split(3,L))]),
%      L.


% extract(R, L) when is_record(R, xmlElement) ->
%      case R#xmlElement.name of
%       source ->
%         lists:foldl(fun extract/2, L, R#xmlElement.content);
%         _ -> % for any other XML elements, simply iterate over children
%           lists:foldl(fun extract/2, L, R#xmlElement.content)
%       end;


% extract(#xmlText{parents=[{title,_},{channel,2},_], value=V}, L) ->
%   [{channel, V}|L]; % extract channel/audiocast title
        
% extract(#xmlText{parents=[{title,_},{item,_},_,_], value=V}, L) ->
%   [{title, V}|L]; % extract episode title
        
% extract(#xmlText{parents=[{link,_},{item,_},_,_], value=V}, L) ->
%   [{link, V}|L]; % extract episode link
        
% extract(#xmlText{parents=[{pubDate,_},{item,_},_,_], value=V}, L) ->
%   [{pubDate, V}|L]; % extract episode publication date ('pubDate' tag)
        
% extract(#xmlText{parents=[{'dc:date',_},{item,_},_,_], value=V}, L) ->
%   [{pubDate, V}|L]; % extract episode publication date ('dc:date' tag)
        
%   extract(#xmlText{}, L) -> L.  % ignore any other text data