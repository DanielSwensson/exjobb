setlocal ENABLEDELAYEDEXPANSION
set COUNT=1
for /d %%d in (*) do (
	ren "%%d" dir!COUNT!
	set /A COUNT=!COUNT! + 1
)