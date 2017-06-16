package com.palvair.infrastructure;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class ServletConfiguration {

    @Bean
    public ServletRegistrationBean jminixServlet() {
        ServletRegistrationBean servletBean = new ServletRegistrationBean();
        servletBean.addUrlMappings("/jminix/*");
        servletBean.setServlet(new org.jminix.console.servlet.MiniConsoleServlet());
        return servletBean;
    }

    // one needs to exclude this filter for jminix to work
    @Bean
    public FilterRegistrationBean excludeDefaultFilter(HiddenHttpMethodFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }

    @Bean
    public JacksonJsonProvider jacksonJsonProvider() {
        return new JacksonJsonProvider();
    }
}
