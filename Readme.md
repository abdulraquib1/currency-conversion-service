# Spring Cloud : Currency-Conversion-Service
 
** Demonstrates reading properties from application.properties **

** Uses Springboot 2.2.4.RELEASE **

** Currency Conversion Service 8100, 8101, 8102, ... **

 

**  http://localhost:8100/currency-converter/from/USD/to/INR/quantity/1000 **
**  http://localhost:8100/h2-console/ **  

```
Overview of features
* Multiple instances of Currency COnversion Service can load the config changes from spring
* cloud config server rather than changing and bundling in each server
* Updated the JPA Mappings with data.sql and entity annotations. 
* Create JPA ExchangeValueRepository and update the controller to lookup date from repository

```


** References **

[Spring properties reference](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)

[MD File Syntax](https://confluence.atlassian.com/bitbucketserver/markdown-syntax-guide-776639995.html)

[In28mins Github Resource Config](https://github.com/in28minutes/spring-microservices/tree/master/03.microservices)
[Install Github on local](https://git-scm.com/)
