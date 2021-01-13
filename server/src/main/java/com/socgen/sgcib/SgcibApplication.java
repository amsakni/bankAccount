package com.socgen.sgcib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.socgen.sgcib.util.mapper.SelmaMapper;

import fr.xebia.extras.selma.Selma;

@SpringBootApplication
public class SgcibApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgcibApplication.class, args);
	}
	
	@Bean
    public SelmaMapper getMapper() {
        return Selma.builder(SelmaMapper.class).build();
    } 

}
