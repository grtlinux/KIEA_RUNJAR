@echo on

::-----------------------------------------------------------------------------------------
:ENV

set JAVA_HOME=N:\PROG\jdk1.7.0_79
set PATH=%PATH%;%JAVA_HOME%\bin

set LIB_PATH=N:\WORK\workspaceluna7_git_deploy1\RunJar\libs

set JOB_NAME=tain-runjar-1.0

::-----------------------------------------------------------------------------------------
:MK_DIR

mkdir %JOB_NAME%

cd %JOB_NAME%

::-----------------------------------------------------------------------------------------
:JAR_XVF

jar xvf ../%JOB_NAME%.jar

::-----------------------------------------------------------------------------------------
:COPY_LIBS

mkdir lib1
mkdir lib2
mkdir lib3

copy %LIB_PATH%\ant.jar              lib1
copy %LIB_PATH%\commons-net-3.3.jar  lib2
copy %LIB_PATH%\log4j-1.2.17.jar     lib3

::-----------------------------------------------------------------------------------------
:MAKE_MANIFEST

echo Class-Path: ./lib1 >  manifest.txt
:: echo  ./lib1 >> manifest.txt
echo  ant.jar >> manifest.txt
echo  ./lib2 >> manifest.txt
echo  commons-net-3.3.jar >> manifest.txt
echo  ./lib3 >> manifest.txt
echo  log4j-1.2.17.jar >> manifest.txt
echo Main-Class: tain.kr.main.Main >> manifest.txt

::-----------------------------------------------------------------------------------------
:JAR_CVMF

jar cvfm ../%JOB_NAME%.jar manifest.txt *

jar cvfM ../%JOB_NAME%.jar *

::-----------------------------------------------------------------------------------------
:RM_FOLDER

cd ..

::rmdir /S /Q %JOB_NAME%
rmdir /S %JOB_NAME%

::-----------------------------------------------------------------------------------------
:RUN_JAR

java -jar %JOB_NAME%.jar

::-----------------------------------------------------------------------------------------
:END

timeout 2

