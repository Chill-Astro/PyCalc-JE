To Build and Run this Project, you need to have JDK installed on your machine.

To Compile from source :

javac *.java

If using precompiled PyCalc_JE.class, JDK-24 or higher is required.

Once compiled do this :

jar cfm PyCalc-JE.jar manifest.txt PyCalc_JE.class OpenScan.class Net_Update.class

To run the CUI App :

java -jar PyCalc-JE.jar

To convert to a Windows .exe or Linux Executable, use GraalVM as given :

native-image -jar PyCalc-JE.jar PyCalc-JE --enable-url-protocols=https

Another method to turn it into a .exe is by using Launch4j to do it. JRE can be bundled too!

Hope this helps,

Chill-Astro