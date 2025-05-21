package com.deyvidsalvatore.shopinventory_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = PageSerializationMode.VIA_DTO)
public class ShopinventoryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopinventoryApiApplication.class, args);
	}

}
