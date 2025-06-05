package com.lalit.kumar.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Student Management API", description = "API for managing student data (CRUD operations)", version = "1.0", contact = @Contact(name = "Lalit Kumar", email = "lalit@example.com"), license = @License(name = "Apache 2.0", url = "http://springdoc.org")), servers = {
		@Server(url = "http://localhost:8083", description = "Local Server") }, tags = {
				@Tag(name = "Student", description = "Operations related to student entity") })
public class SwaggerConfig {
}
