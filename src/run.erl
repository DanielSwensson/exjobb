-module(run).
-compile(export_all).

test() ->
  checkstyle:run("../testcode/","testcodeResults").

test_from_backup() ->
   checkstyle:save_from_backup("results/Backup_testcodeResults").

test_summarize() ->
	summarize:start(["results/Backup_testcodeResults","results/Backup_prog21Results"]).	

oop1() ->
   checkstyle:run("../oop1/","oop1Results").

oop2() ->
   checkstyle:run("../oop2/","oop2Results").

oop22012() ->
	checkstyle:run("../oop2-2012/", "oop22012Results").

alda() ->
   checkstyle:run("../alda/","aldaResults").

prog21() ->
   checkstyle:run("../PROG21/","prog21Results").

prog22() ->
   checkstyle:run("../PROG22/","prog22Results").
