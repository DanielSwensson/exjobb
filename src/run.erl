-module(run).
-compile(export_all).

test() ->
  checkstyle:run("../testcode/","testcodeResults").

test_from_backup() ->
   checkstyle:save_from_backup("results/Backup_testcodeResults").

oop1() ->
   checkstyle:run("../oop1/","oop1Results").

oop2() ->
   checkstyle:run("../oop2/","oop2Results").

alda() ->
   checkstyle:run("../alda/","aldaResults").

prog21() ->
   checkstyle:run("../PROG21/","prog21Results").

prog22() ->
   checkstyle:run("../PROG22/","prog22Results").