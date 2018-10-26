## RunJar04

> version: 4.0  
> comment: show menu  

### library

> src/META-INF  
> src/META-INF/lib/*.jar <---- here  
> src/META-INF/MANIFEST.MF  

### be job

	DOS> java -jar RunJar01.jar

	DOS> set JAVA_HOME=C:\tain\java\jdk1.7.0_79

	DOS> set PATH=%JAVA_HOME%\bin;%PATH%

	DOS> java -version
		java version "1.7.0_79"
		Java(TM) SE Runtime Environment (build 1.7.0_79-b15)
		Java HotSpot(TM) 64-Bit Server VM (build 24.79-b02, mixed mode)

	DOS> javac -cp ".;out/META-INF/lib/*" -d out src/org/tain/runjar/*.java src/org/tain/utils/*.java src/org/tain/main/*.java

	DOS> jar cvfm RunJar01.jar out/META-INF/MANIFEST.MF -C out .

	DOS> java -jar KieaThomson.jar

	DOS> tree /f /a


### References

[]("")  
.....

