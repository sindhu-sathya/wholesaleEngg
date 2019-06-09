/**
 * @author Sindhu
 * Date: 9-June-2019
 */
package com.igreen.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * Spring Boot Start Up Class
 *
 */
@SpringBootApplication( scanBasePackages = { "com.igreen.ex" })
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
