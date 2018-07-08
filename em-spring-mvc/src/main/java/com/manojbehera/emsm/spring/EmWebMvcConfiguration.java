package com.manojbehera.emsm.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class EmWebMvcConfiguration extends WebMvcConfigurerAdapter {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addViewController("/login").setViewName("loginPage");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}
}
