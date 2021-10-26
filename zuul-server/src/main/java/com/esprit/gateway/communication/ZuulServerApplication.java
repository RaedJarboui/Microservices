package com.esprit.gateway.communication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.esprit.gateway.filters.ErrorFilter;
import com.esprit.gateway.filters.PostFilter;
import com.esprit.gateway.filters.PreFilter;
import com.esprit.gateway.filters.RouteFilter;

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
