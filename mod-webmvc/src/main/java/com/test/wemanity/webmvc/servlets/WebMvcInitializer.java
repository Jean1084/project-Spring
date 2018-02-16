package com.test.wemanity.webmvc.servlets;

import com.test.wemanity.webmvc.WebMvcApp;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * Created by JeanDodo on 15/02/2018.
 */
public class WebMvcInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebMvcApp.class);
        context.setServletContext(servletContext);

        Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);
    }
}
