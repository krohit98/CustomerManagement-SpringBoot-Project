package com.cg.apps.customermgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.apps.customermgt.customerms.ui.CustomerUI;
import com.cg.apps.customermgt.itemms.ui.ItemUI;


@SpringBootApplication
public class CustomerApplication {

	public static void main(String args[]) {
		ConfigurableApplicationContext context=SpringApplication.run(CustomerApplication.class, args);
		CustomerUI app1 = context.getBean(CustomerUI.class);
		ItemUI app2 = context.getBean(ItemUI.class);
		app1.start();
		app2.start();
	}
}
