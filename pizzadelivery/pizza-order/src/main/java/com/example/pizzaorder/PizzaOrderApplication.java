package com.example.pizzaorder;

import com.example.pizzaorder.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableFeignClients
public class PizzaOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaOrderApplication.class, args);
	}


	@Bean
	public FilterRegistrationBean filterUrl(){
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.addUrlPatterns("/api/v2/addPizza","/api/v2/cancelOrder/*","/api/v2/showCatalogue","/api/v2/showCart","/api/v2/addPizzaInCatalague","/api/v2/addToCart","/api/v2/showCard/*");
		return filterRegistrationBean;

	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:4200");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**",config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

		return bean;

	}


}