@echo off
set str=%1
echo.%str%

rem java -cp %str% 



@call java -cp src;classes;lib\clojure.jar clojure.main %str