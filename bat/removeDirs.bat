:remove (now empty) folders
for /d %%d in (*) do (
	rd %%d /S /Q
)