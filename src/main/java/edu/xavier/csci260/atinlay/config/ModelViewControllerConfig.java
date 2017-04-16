package edu.xavier.csci260.atinlay.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * class ___ is a member of the atinlay project.
 * <p>
 * Created by Luke on 3/12/2017.
 */
@Configuration
public class ModelViewControllerConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/addEmployee").setViewName("addEmployee");
        registry.addViewController("/messages").setViewName("messages");
        registry.addViewController("/requests").setViewName("requests");
        registry.addViewController("/newRequest").setViewName("newRequest");
    }

   /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/static/**")) {
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        }
    }*/
}
