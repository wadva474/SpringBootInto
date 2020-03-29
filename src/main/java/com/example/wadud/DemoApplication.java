package com.example.wadud;


import com.example.wadud.servlet.HelloServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    ///Register Servlet
    @Bean
    public ServletRegistrationBean<HelloServlet> getServletRegistrationBean() {
        ServletRegistrationBean<HelloServlet> servletRegistrationBean = new ServletRegistrationBean<>(new HelloServlet());
        servletRegistrationBean.addUrlMappings("/helloServlet");
        return servletRegistrationBean;
    }

    ///Register Filter
    @Bean
    public FilterRegistrationBean<HelloServlet.HelloFilter> getFilterRegistrationBean() {
        FilterRegistrationBean<HelloServlet.HelloFilter> filterRegistrationBean = new FilterRegistrationBean<>(new HelloServlet.HelloFilter());
        filterRegistrationBean.addUrlPatterns("/helloServlet");
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<HelloServlet.HelloListeners> getServletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<>(new HelloServlet.HelloListeners());
    }


}
