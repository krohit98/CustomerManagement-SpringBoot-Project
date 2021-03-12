package com.cg.apps.customermgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.apps.customermgt.customerms.ui.CustomerUI;


@SpringBootApplication
public class CustomerApplication {

	public static void main(String args[]) {
		ConfigurableApplicationContext context=SpringApplication.run(CustomerApplication.class, args);
		CustomerUI app = context.getBean(CustomerUI.class);
		app.start();
	}
}
