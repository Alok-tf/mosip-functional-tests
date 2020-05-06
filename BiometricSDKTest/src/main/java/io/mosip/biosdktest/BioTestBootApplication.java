package io.mosip.biosdktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Manoj SP
 *
 */
@SpringBootApplication
public class BioTestBootApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(BioTestBootApplication.class, args);
		SpringApplication.exit(applicationContext);
	}

}
