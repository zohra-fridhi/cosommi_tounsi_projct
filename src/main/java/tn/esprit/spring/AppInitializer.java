package tn.esprit.spring;

import javax.servlet.ServletContext;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import tn.esprit.spring.util.FiltreBadWords;



public class AppInitializer implements WebApplicationInitializer {
	 @Override
	    public void onStartup(ServletContext sc) {

	 FiltreBadWords.loadConfigs();

	    }}
