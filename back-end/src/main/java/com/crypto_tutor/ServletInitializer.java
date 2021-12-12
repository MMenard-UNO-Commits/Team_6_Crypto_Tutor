package com.crypto_tutor;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * gets information for the spring boot application like location of database and other important information
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * starts building the spring boot application
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BackEndApplication.class);
	}

}
