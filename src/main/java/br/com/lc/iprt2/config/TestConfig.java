package br.com.lc.iprt2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.lc.iprt2.service.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	
	@Autowired
	private DBService dbService;
	
	@Bean
	public String instanciaDB() {
		this.dbService.instanciaDB();
		return null;
	}
}
