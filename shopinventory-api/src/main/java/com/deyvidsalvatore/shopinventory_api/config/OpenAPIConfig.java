package com.deyvidsalvatore.shopinventory_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {
	@Bean
	OpenAPI customOpenApi() {
		return new OpenAPI().info(this.apiInfo());
	}

	private Info apiInfo() {
		return new Info()
				.title("ShopInventory API")
				.version("1.0")
				.description("REST API's for Inventory Managing App")
				.termsOfService("https://github.com/deyvidsalvatore/ShopInventory2025#readme")
				.license(
						new License()
						  .name("Apache 2.0")
						  .url("https://www.apache.org/licenses/LICENSE-2.0")
				);
	}
}
