package com.github.eliog.currencyconverter;

import com.github.eliog.currencyconverter.training.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
@EnableScheduling
// to make spring check the components
@ComponentScan({"com.github.eliog.currencyconverter.controller", "com.github.eliog.currencyconverter.security",
		"com.github.eliog.currencyconverter.config"})
// to enable jpa auditing
//@EnableJpaAuditing
public class CurrencyConverterApplication {

	// to run: ./mvnw spring-boot:run
	// to create jar: ./mvnw clean package
	// to test: either website or curl localhost:8080/whatever
	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterApplication.class, args);
	}

//	// to check out all the beans wrapped into the application
//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//
//		};
//	}

//	// to consume the RESTful Web service (I guess I am adding a Bean to the existing ones):
//	// to send output to the log
//	private static final Logger log = LoggerFactory.getLogger(CurrencyConverterApplication.class);
//	// uses Jackson processing library to process the incoming data
//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}
//
//	// runs the RestTemplate on startup
//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//		return args -> {
//			Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//			log.info(quote.toString());
//		};
//	}
}
