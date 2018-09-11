package com.liuhaolei.dreamer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@ComponentScan(basePackages = {"com.liuhaolei.dreamer"}, 
includeFilters = @Filter(type = FilterType.ANNOTATION, classes = {Controller.class}))
public class DreamerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DreamerApplication.class, args);
	}
}
