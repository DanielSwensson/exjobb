-module(summarize).
-compile(export_all).


start(ResultsFiles) -> 
	AllResults = run(ResultsFiles),
	ok.

run([]) -> [];
run([ResultFile | ResultsFiles]) ->
	{ok, Binary} = file:read_file(ResultFile),
 	{Results,Count,Stddiv,NrLines, AverageComments ,FileName} = binary_to_term(Binary),
	StandardAndDeviations = lists:map(
		fun({Type, AverageList}) ->
				[{Type, stddiv:run(AverageList)}]
		end,
		Stddiv
	),
	erlang:display(StandardAndDeviations),
 	[{FileName, AverageComments, NrLines, Count, StandardAndDeviations}] ++ run(ResultsFiles).
		




