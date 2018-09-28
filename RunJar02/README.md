DOS> javac -cp ".;out/lib/*" -d out src/org/tain/runjar/*.java src/org/tain/utils/*.java src/org/tain/main/*.java

DOS> jar cvfm GsonTest.jar src/META-INF/MANIFEST.MF -C out .

DOS> java -jar GsonTest.jar

.....
DOS> tree /f /a
VBOX__VB_SHARE 볼륨에 대한 폴더 경로의 목록입니다.
볼륨 일련 번호는 0100-0004입니다.
E:.
|   GsonTest.jar
|
+---out
|   +---org
|   |   \---tain
|   |       +---runjar
|   |       |       RunJarLoader$1.class
|   |       |       RunJarLoader.class
|   |       |       RunJarLoader$ManifestInfo.class
|   |       |       RsrcURLConnection.class
|   |       |       RsrcURLStreamHandlerFactory.class
|   |       |       RsrcURLStreamHandler.class
|   |       |
|   |       +---utils
|   |       |       ClassUtils.class
|   |       |       GsonUtils$1.class
|   |       |       GsonUtils$2.class
|   |       |       GsonUtils.class
|   |       |
|   |       \---main
|   |               GsonTestMain.class
|   |               GsonTestMain$Person.class
|   |               GsonTestMain$2.class
|   |               GsonTestMain$1.class
|   |               GsonTestMain$3.class
|   |
|   \---lib
|           gson-2.7.jar
|
\---src
    +---org
    |   \---tain
    |       +---runjar
    |       |       RsrcURLConnection.java
    |       |       RsrcURLStreamHandler.java
    |       |       RsrcURLStreamHandlerFactory.java
    |       |       RunJarLoader.java
    |       |
    |       +---utils
    |       |       ClassUtils.java
    |       |       GsonUtils.java
    |       |
    |       \---main
    |               GsonTestMain.java
    |
    \---META-INF
            MANIFEST.MF

