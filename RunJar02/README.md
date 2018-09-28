DOS> javac -cp ".;out/lib/*" -d out src/org/tain/runjar/*.java src/org/tain/utils/*.java src/org/tain/main/*.java

DOS> jar cvfm GsonTest.jar src/META-INF/MANIFEST.MF -C out .

DOS> java -jar GsonTest.jar

.....
