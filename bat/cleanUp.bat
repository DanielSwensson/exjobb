:level and clean up every folder in current directory
for /d %%d in (*) do (
	cd %%d
	..\levelTree
	..\removeDirs
	cd ..
)
