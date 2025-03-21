package com.jaya.springMVC_learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {
   @Bean
   public InternalResourceViewResolver jspViewResolver(){
       InternalResourceViewResolver resolver = new InternalResourceViewResolver();
       resolver.setPrefix("/WEB-INF/views");
       resolver.setOrder(0);
       resolver.setViewNames("jsp/*");
       return resolver;
   }
}
