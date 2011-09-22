####This directory contains example code used during the demo and a sample web application                


## Setting up the development environment

### Install JDK
Before you can start using Grails you will need to install a Java SDK (not just a JRE) and set the JAVA_HOME environment variable to the location of that SDK

The latest JDK can be downloaded from here http://www.oracle.com/technetwork/java/javase/downloads/index.html

### Install Groovy

1. Download a binary distribution of Groovy and unpack it into some file on your local file system
2. Set your GROOVY_HOME environment variable to the directory you unpacked the distribution
3. Add GROOVY_HOME/bin to your PATH environment variable

You should now have Groovy installed properly. You can test this by typing the following in a command shell:

```bash
  groovysh
```

### Install Grails 

1. Download the latest Grails release
2. Extract the archive into an appropriate location; typically C:\grails on Windows or ~/grails on Unix
3. Create a GRAILS_HOME environment variable that points to the path where you extracted the archive (eg C:\grails on Windows or ~/grails on Unix)
4. Append a reference to the "bin" directory within the Grails directory to your PATH variable (eg %GRAILS_HOME%\bin on Windows or $GRAILS_HOME/bin on Unix). Note that, for Windows, both PATH and GRAILS_HOME must be defined at the same environment variable level (eg. 'System variables') rather than across environment variable levels (eg. PATH under 'System variables' and GRAILS_HOME under 'User variables')
5. Type "grails" at the command line, if a help message is displayed you are ready to start using Grails!

####Optional
### Install MySQL
Please follow the instructions here to download and install MySQL http://dev.mysql.com/doc/refman/5.1/en/installing.html
              