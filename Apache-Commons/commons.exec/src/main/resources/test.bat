@echo off

title 创建日志文件

cls

echo.

echo ********************************************** 

echo. 

echo 正在创建日志文件...

echo. 

echo ********************************************** 

echo. 

::获取当前日期

set date=%date:~0,4%%date:~5,2%%date:~8,2%

::创建日志文件

echo "Hello World " > %date%.log