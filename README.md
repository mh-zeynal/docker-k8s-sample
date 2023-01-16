# Docker sample app

# About The Project
This is an application for Docker practice

|Endpoint | Description  |
|--------------------------|---|
|/hello | returns "Hello Stranger" |
|/hello?name=mhzz | returns "Hello mhzz" (camel case gets cut by spaces)|
|/author | returns "Mohammad-Hossein Zeynalzadeh" |

## Running sample application locally
this app is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line (it should work just as well with Java 11 or newer):


```
git clone https://github.com/mh-zeynal/docker-sample.git
cd docker-sample
./mvnw package
java -jar target/*.jar
```

You can then access the app here: http://localhost:8080/hello


Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```
./mvnw spring-boot:run
```

> NOTE: Windows users should set `git config core.autocrlf true` to avoid format assertions failing the build (use `--global` to set that flag globally).

### Docker instruction

1. Ensure your docker installed. [See here](https://www.docker.com/products/docker-desktop)

2. Go to project's root directory

3. Now you have two options  
    3.1:
    - Run docker build -t demo .  
    - Then run docker run -p 8080:8080 demo  
    
    **or**

    3.2:
    - Run docker-compose up  

5. Visit http://localhost:8080/hello

>**NOTE**: erase "novinrepo:8082/docker/" from both ***docker-compose.yml*** and ***dockerfile***

## Working with docker-sample App in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 17 or newer (full JDK not a JRE).
* git command line tool (https://help.github.com/articles/set-up-git)
* Your preferred IDE
    * Eclipse with the m2e plugin. Note: when m2e is available, there is an m2 icon in `Help -> About` dialog. If m2e is
      not there, just follow the install process here: https://www.eclipse.org/m2e/
    * [Spring Tools Suite](https://spring.io/tools) (STS)
    * IntelliJ IDEA
    * [VS Code](https://code.visualstudio.com)

