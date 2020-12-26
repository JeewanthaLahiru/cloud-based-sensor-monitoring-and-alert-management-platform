package com.monitor.monitorapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(scanBasePackages={"com.monitor.monitorapp", "com.monitor.database"})
@ComponentScan("com.monitor")
@EnableMongoRepositories("com.monitor")
public class MonitorappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorappApplication.class, args);
	}

}
