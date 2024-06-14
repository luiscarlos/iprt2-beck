package br.com.lc.iprt2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.lc.iprt2.service.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String values;

	@Bean
	public boolean instanciaDB() {

		if (values.equals("create")) {
			this.dbService.instanciaDB();
		}

		return false;
	}
}
