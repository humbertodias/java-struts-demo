# Java Struts Demo

Struts 2 service for my demonstration.

# Prerequisites

1. [Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 8+
2. [Maven](https://maven.apache.org) 3+
3. [Struts](https://struts.apache.org) 2+

# How to run

Clone

```
git clone https://github.com/humbertodias/java-struts-demo
```

Inside

```
cd java-soap-demo
```

Run

```
mvn package
mvn embedded-glassfish:run -Dhttp.port=8080
```


Output

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
jun 07, 2018 6:16:59 PM org.glassfish.webservices.metroglue.MetroContainer deployWsTxServices
INFO: Loading WS-TX Services. Please wait.
jun 07, 2018 6:16:59 PM org.glassfish.webservices.metroglue.MetroContainer deployWsTxServices
WARNING: Cannot deploy or load WS-TX Services: Required WAR file (wstx-services.war) is not installed
jun 07, 2018 6:16:59 PM org.glassfish.deployment.admin.DeployCommand execute
INFO: Deployed calculadora-jax-ws
Hit ENTER to redeploy, X to exit
```


Endpoint

[http://localhost:8080/](http://localhost:8080/)

![](doc/list.png)


# References

[Maven plugin for GlassFish](https://jinahya.wordpress.com/2015/04/23/using-maven-embedded-glassfish-plugin-4-x/)