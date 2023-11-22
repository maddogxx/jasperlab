package com.lab.jasper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.lab.jasper.domain.VersaoEnum;

@SpringBootApplication
public class JasperApplication {
	
	@Autowired
	private GeradorRelatorio gerador;
	
	public static void main(String[] args) {
		SpringApplication.run(JasperApplication.class, args);
	}

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			gerador.gerarRelatorio(VersaoEnum.V1);
//			gerador.gerarRelatorio(VersaoEnum.V2);
		};
	}	

}
