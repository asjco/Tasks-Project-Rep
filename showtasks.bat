call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openbrowser
echo runcrud script has errors - breaking work
goto fail

:openbrowser
start http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo something wrong with browser
goto fail

:fail
echo.
echo Errors occurred

:end
echo showtasks script is finished