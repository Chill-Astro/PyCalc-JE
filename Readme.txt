To Build and Run this Project, you need to have JDK installed on your machine.

To Compile from source, 
javac PyCalc_JE.java

If using precompiled PyCalc_JE.class, JDK-24 or higher is required.

Once compiled do this :
jar cfm PyCalc-JE.jar manifest.txt PyCalc_JE.class

To run the CUI App, 
java -jar PyCalc-JE.jar

If using .exe, make sure to have JDK / JRE installed.
To make this new .jar as an .exe, use Launch4j to do it. JRE can be bundled too!

Hope this helps,

Chill-Astro