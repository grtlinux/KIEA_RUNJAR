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

	DOS> java -jar RunJar01.jar
		>>>>> org.tain.main.UsageMain.main() - UsageMain.java(44)
		>>>>> org.tain.main.UsageMain.run01() - UsageMain.java(18)
		>>>>> arguments: []
		---------- arg0: test01 -----------
		COMMENT: test01 project
		USAGE: java -jar RunJar.jar test01 args...
		
		---------- arg0: test02 -----------
		COMMENT: test02 project
		USAGE: java -jar RunJar.jar test02 args...

	DOS> java -jar RunJar01.jar test01 1 2 3
		>>>>> org.tain.main.Test01Main.main() - Test01Main.java(28)
		>>>>> org.tain.main.Test01Main.run01() - Test01Main.java(18)
		>>>>> [1, 2, 3]

	DOS> java -jar RunJar01.jar test02
		>>>>> org.tain.main.Test02Main.main() - Test02Main.java(28)
		>>>>> org.tain.main.Test02Main.run01() - Test02Main.java(18)
		>>>>> []

	DOS> java -jar RunJar01.jar test03
		Exception in thread "main" java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key
		org.tain.runjar.test03
		        at java.util.ResourceBundle.getObject(ResourceBundle.java:395)
		        at java.util.ResourceBundle.getString(ResourceBundle.java:355)
		        at org.tain.runjar.RunJarLoader.run03(RunJarLoader.java:204)
		        at org.tain.runjar.RunJarLoader.main(RunJarLoader.java:288)

	DOS> tree /f /a
		SSD250_SYS 볼륨에 대한 폴더 경로의 목록입니다.
		볼륨 일련 번호는 7838-8355입니다.
		C:.
		|   RunJar01.jar
		|
		+---out
		|   |   log4j.properties
		|   |   resources.properties
		|   |
		|   +---META-INF
		|   |   |   MANIFEST.MF
		|   |   |
		|   |   \---lib
		|   |           json-20180813.jar
		|   |           log4j-1.2.17.jar
		|   |           slf4j-api-1.7.12.jar
		|   |           slf4j-jdk14-1.7.12.jar
		|   |
		|   \---org
		|       \---tain
		|           +---main
		|           |       Test01Main.class
		|           |       Test02Main.class
		|           |       UsageMain.class
		|           |
		|           +---runjar
		|           |       RsrcURLConnection.class
		|           |       RsrcURLStreamHandler.class
		|           |       RsrcURLStreamHandlerFactory.class
		|           |       RunJarLoader$1.class
		|           |       RunJarLoader.class
		|           |
		|           \---utils
		|                   ClassUtils.class
		|                   JacksonUtils.class
		|
		\---src
		    |   log4j.properties
		    |   resources.properties
		    |
		    +---META-INF
		    |   |   MANIFEST.MF
		    |   |
		    |   \---lib
		    |           json-20180813.jar
		    |           log4j-1.2.17.jar
		    |           slf4j-api-1.7.12.jar
		    |           slf4j-jdk14-1.7.12.jar
		    |
		    \---org
		        \---tain
		            +---main
		            |       Test01Main.java
		            |       Test02Main.java
		            |       UsageMain.java
		            |
		            +---runjar
		            |       RsrcURLConnection.java
		            |       RsrcURLStreamHandler.java
		            |       RsrcURLStreamHandlerFactory.java
		            |       RunJarLoader.java
		            |
		            \---utils
		                    ClassUtils.java
		                    JacksonUtils.java
		                    

### References

[]("")  
.....

