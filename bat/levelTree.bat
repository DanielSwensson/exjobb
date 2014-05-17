:move all java-files to initial dir, remove everything else
for /r %%f in (*) do (
	if %%~xf==.java move "%%f" "%CD%"
	if NOT %%~xf==.java del "%%f"
)