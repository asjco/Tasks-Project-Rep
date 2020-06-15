call runcrud.bat
echo %ERRORLEVEL%
if %ERRORLEVEL% == "0" goto runchrome
echo cos sie popsulo
goto fail

:runchrome
call start chrome http://localhost:8080/crud/v1/task/getTasks
if %ERRORLEVEL% == "0" goto end
echo Cannot run Chrome
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.