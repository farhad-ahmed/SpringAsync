package com.farhad.poweroftwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.sql.Timestamp;

@SpringBootApplication
@EnableAsync
public class PoweroftwoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(PoweroftwoApplication.class, args);
		Caller c=(Caller)ctx.getBean("caller");
		System.out.println("**************************************************");
		System.out.println("Main Method Calling Future " +new Timestamp(System.currentTimeMillis()));
		//c.work();
		c.futureWork();
		System.out.println("**************************************************");
	}


}
