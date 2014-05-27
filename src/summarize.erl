-module(summarize).
-compile(export_all).


start(ResultsFiles) -> 
	{Averages, Deviations} = read_results(ResultsFiles, dict:new(), dict:new()),
	[ io:format("Key: ~p Value: ~p ~n",[Key,dict:to_list(Value)]) || {Key, Value} <- dict:to_list(Averages)].
	
	
read_results([], Averages, Deviations) -> {Averages, Deviations}; 
read_results([ResultFile | ResultsFiles], Averages, Deviations) ->
	{ok, Binary} = file:read_file(ResultFile),
 	{Results,Count,Stddiv,NrLines, AverageComments ,FileName} = binary_to_term(Binary),
	{Averages1, Deviations1} = for_stddiv(Stddiv,Averages,Deviations,FileName),
	read_results(ResultsFiles, Averages1, Deviations1).

for_stddiv([],Averages,Deviations,_) -> {Averages,Deviations};
for_stddiv([{Type,AverageList} | Stddiv], Averages,Deviations,FileName) ->
		{Average,Deviation} = stddiv:run(AverageList),
		Averages1 = update(Averages,Average,Type,FileName),
		Deviations1 = update(Deviations,Deviation,Type,FileName),
		for_stddiv(Stddiv,Averages1,Deviations1,FileName).

update(Dict,Value,Key,FileName) ->
	case dict:is_key(Key,Dict) of 
		true ->
			FilesDict = dict:fetch(Key,Dict),
			FilesDict1 = dict:store(FileName,Value,FilesDict),
			dict:store(Key,FilesDict1, Dict);
		false ->
			FilesDict = dict:new(),
			FilesDict1 = dict:store(FileName,Value,FilesDict),
			dict:store(Key,FilesDict1,Dict)
	end.
