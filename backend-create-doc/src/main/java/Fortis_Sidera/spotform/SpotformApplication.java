package Fortis_Sidera.spotform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SpotformApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotformApplication.class, args);
	}

}
