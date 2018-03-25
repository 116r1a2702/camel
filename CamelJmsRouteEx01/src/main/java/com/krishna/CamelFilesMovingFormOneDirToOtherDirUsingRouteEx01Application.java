package com.krishna;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamelFilesMovingFormOneDirToOtherDirUsingRouteEx01Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CamelFilesMovingFormOneDirToOtherDirUsingRouteEx01Application.class, args);
		CamelContext camelContext = new DefaultCamelContext();
		camelContext.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("file:/D:\\Chaitanya\\logs?noop=true").to("file:/D:\\Chaitanya\\Out");
			}
		});
		camelContext.start();
		Thread.sleep(10000);
		camelContext.stop();
		System.out.println("file moved successfully");
	}
}
