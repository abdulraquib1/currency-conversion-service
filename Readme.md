# Spring Cloud : Currency-Conversion-Service
 

** Overview of features **
* Use Rest Template to invoke other Rest Service
* Use properties to load the URL
* Use Feign client to invoke other Service
* Use of Ribbon client for load balancing
* Demonstrates reading properties from application.properties *


** Uses Springboot 2.2.4.RELEASE **
** Currency Conversion Service 8100, 8101, 8102, ... **

 

**  http://localhost:8100/currency-converter/from/USD/to/INR/quantity/1000 - uses Rest Template **

**  http://localhost:8100/currency-converter-feign/from/EUR/to/INR/quantity/1000 -use Feign Client**

**  http://localhost:8100/h2-console/ **  

```

//For Fiegn client
Step 1
<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>

Step 2:
@EnableFeignClients("com.raq.springcloud")
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}
	
	
Step 3:
@FeignClient(name="currency-exchange-service",url="localhost:8000")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") 	String to);

}

Step 4:
Use this method in the controller
convertCurrencyUsingFeign


//For Ribbon Naming Server	

Step 1
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>
		
Step 2
@FeignClient(name="currency-exchange-service")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

Step3
Application.properties
currency-exchange-service.ribbon.listOfServers=http://localhost:8000,http://localhost:8001

```


** References **

* [Spring properties reference](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)
* [Spring Configurations](https://www.baeldung.com/properties-with-spring)
* [MD File Syntax](https://confluence.atlassian.com/bitbucketserver/markdown-syntax-guide-776639995.html)
* [In28mins Github Resource Config](https://github.com/in28minutes/spring-microservices/tree/master/03.microservices)
* [Install Github on local](https://git-scm.com/)
