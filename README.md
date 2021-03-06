# Spring Boot,NodeJs, Spring Cloud Netflix Eureka, Spring CLoud Zuul, Spring Data JPA, H2,MongoDb.
![spring-cloud-routing-with-zuul-gateway-0](https://user-images.githubusercontent.com/47774267/139234555-fc22915a-9dc0-4cd3-8e35-efdd5acad94d.jpg)


## Overview
### The architecture is composed by eight services:

   * [`Eureka`](https://github.com/RaedJarboui/Microservices/tree/master/Eureka): Service **Discovery Server** created with Eureka
   
   * [`zuul-server`](https://github.com/RaedJarboui/Microservices/tree/master/zuul-server): API Gateway created with Zuul that uses the discovery-service to send the requests to the services. It uses Ribbon as a Load Balancer
   
   * [`personnel`](https://github.com/RaedJarboui/Microservices/tree/master/personnel): Simple REST service created with `Spring Boot, Spring Data JPA, H2`
   
   * [`ReservationMS`](https://github.com/RaedJarboui/Microservices/tree/master/ReservationMS): Simple REST service created with `Spring Boot, Spring Data JPA, H2`
   
   * [`MS-client`](https://github.com/RaedJarboui/Microservices/tree/master/MS-client): Simple REST service created with `NodeJS,mongodb`

   * [`Aero`](https://github.com/RaedJarboui/Microservices/tree/master/Aero): Simple REST service created with `Spring Boot, Spring Data JPA, H2`

### Tools we was used
* Maven 3.0+ 

* IDE `STS-3.4.9-RELEASE` `Eclipse` `Visual Studio`.

* `H2`, `MongoDb`

* JDK 1.8+

* Docker Desktop

### Microservice Running Process:

- First we need to run `Eureka`
- Second  we need to run `personnel`,`ReservationMS`,`MS-client` and `Aero`
- Finally we need to run `zuul-server`, if we did run `zuul-server` before running the microservices then we have to wait approximately 10 second 



## Eureka Service

Eureka Server is an application that holds the information about all client-service applications. Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address. Eureka Server is also known as Discovery Server.

### Implementing a Eureka Server for service registry is as easy as

we need to add `@EnableEurekaServer` annotation. The `@EnableEurekaServer` annotation is used to make your Spring Boot application acts as a Eureka Server.

```
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

	public static void main(String[] args) {

		SpringApplication.run(EurekaApplication.class, args);
	}

}

```

we should make sure Spring cloud Eureka server dependency is added in our build configuration file.
The code for Maven user dependency is shown below ???

```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

By default, the Eureka Server registers itself into the discovery. we added the below given configuration into our `application.properties` 

```
# Give a name to the eureka server
spring.application.name=eureka-service
# default port for eureka server
server.port=8761
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false



# eureka by default will register itself as a client. So, we need to set it to false.
# What's a client server? See other microservices personnel,ReservationMS,MS-client,CandidateMS,and Aero
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=false
```

## API Gateway Service

A common problem, when building microservices, is to provide a unique gateway to the client applications of our system. The fact that our services are split into small microservices apps that shouldn???t be visible to users otherwise it may result in substantial development/maintenance efforts. Also there are scenarios when whole ecosystem network traffic may be passing through a single point which could impact the performance of the cluster.

### Zuul Components

Zuul has mainly four types of filters that enable us to intercept the traffic in different timeline of the request processing for any particular transaction. We can add any number of filters for a particular url pattern.

- **pre filters** ??? are invoked before the request is routed.
- **post filters** ??? are invoked after the request has been routed.
- **route filters** ??? are used to route the request.
- **error filters** ??? are invoked when an error occurs while handling the request.

![Zull-filters](https://user-images.githubusercontent.com/31319842/101316221-49364a80-3886-11eb-8037-163dd77554c7.jpg)



### Enable Zuul Service Proxy

Now add the `@EnableZuulProxy` and `@EnableEurekaClient` annotation on Spring boot application class present in src folder. With this annotation, this artifact will act like a Zuul service proxy and will enable all the features of a API gateway layer as described before. We will then add some filters and route configurations.

```
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
// @EnableFeignClients
public class ZuulServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(ZuulServerApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {

		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {

		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {

		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {

		return new RouteFilter();
	}

}

```
### Zuul routes configuration
Open application.properties and add below entries-
```
spring.application.name= zuul-service
#Will start the gateway server @8762
server.port= 8762
#eureka config
eureka.client.serviceUrl.defaultZone= http://discovery:8761/eureka/
#eureka.client.serviceUrl.defaultZone= ${EUREKA_URI:http://localhost:8761/eureka}

zuul.routes.candidats-endpoint.serviceId=candidat-service
zuul.routes.candidat-service.path=/job-service/*

zuul.routes.aero-endpoint.serviceId=aero-service
zuul.routes.aero-service.path=/job-service/*

zuul.routes.clients-endpoint.serviceId=clients-service
zuul.routes.clients-service.path=/job-service/*

zuul.routes.personnel-endpoint.serviceId=personnel-service
zuul.routes.personnel.path=/job-service/*

zuul.routes.jobs-endpoint.serviceId=job-service
zuul.routes.job-service.path=/job-service/*

zuul.routes.reservation-endpoint.serviceId=reservation-service
zuul.routes.reservation-service.path=/reservation-service/*

eureka.instance.preferIpAddress=true
eureka.client.registerWithEureka=true
eureka.client.fetchRegistry=true

```

### Add Zuul Filters

We will now add few filters as we have already described, Zuul supports 4 types of filters namely `route`,`error`,`post`,`pre`. 
Here we will create each type of filters.


### route filter

```
public class RouteFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "route";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		System.out.println("Using Route Filter");
		return null;
	}

}
```

### Error filter

```
public class ErrorFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "error";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		System.out.println("Using Error Filter");
		return null;
	}

}
```
### Post filter

```
public class PostFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	/*@Override
	public Object run() {
		System.out.println("Using Post Filter");

		return null;
	}*/

	
	@Override
	public Object run() {
		System.out.println("Using Post Filter");
		
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletResponse servletResponse = context.getResponse();
		
		servletResponse.addHeader("X-Sample", UUID.randomUUID().toString());
		return null;
	}

}
```
### Pre filter

```
public class PreFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		System.out.println(
				"Using Pre filter    Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());

		return null;
	}

}
```


## Aeroport Service

Micro Service Aero : 
```
( POST )- /api/aero => Ajouter un Aeroport
( PUT ) - /api/aero/{id} => Modifier un Aeroport
( DELETE ) - /api/aero/{id} => Suprrimer un Aeroport
( GET ) - /api/aero => Afficher la liste enti??res des Aeroports
( GET ) - /api/aero/{id} => Afficher les d??tails d'un Aeroport

```


## Personnel Service

Micro Service Personnel : 
```
( POST )- /api/personnels => Ajouter un Personnel
( PUT ) - /api/personnels/{id} => Modifier un Personnel
( DELETE ) - /api/personnels/{id} => Suprrimer un Personnel
( GET ) - /api/personnels => Afficher la liste enti??res des Personnels
( GET ) - /api/personnels/{id} => Afficher les d??tails d'un Personnel

```


## Reservation Service

Micro Service Reservation : 
```
( POST )- /api/reservations => Ajouter une Reservation
( PUT ) - /api/reservations/{id} => Modifier une Reservation
( DELETE ) - /api/reservations/{id} => Suprrimer une Reservation
( GET ) - /api/reservations => Afficher la liste enti??res des Reservations
( GET ) - /api/reservations/{id} => Afficher les d??tails d'une Reservation

```


## Client Service

Micro Service Client : 
```
( POST )- /api/clients => Ajouter un Client
( PUT ) - /api/clients/{id} => Modifier un Client
( DELETE ) - /api/clients/{id} => Suprrimer un Client
( GET ) - /api/clients => Afficher la liste enti??res des Clients
( GET ) - /api/clients/{id} => Afficher les d??tails d'un Client

```


	