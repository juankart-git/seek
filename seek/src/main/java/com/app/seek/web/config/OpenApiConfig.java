package com.app.seek.web.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Seek Candidates API",
                description = "API to manage the CURD Seek Candidates",
                summary = "This API will ADD, Delete, GetAll, GetById",
                termsOfService = "TyC",
                contact = @Contact(
                        name = "Juan Carlos Acosta",
                        email = "juankart@hotmail.es"
                ),
                license = @License(
                        name = "License No. BJ1&-UYU8-OK43-23SD-8JU&"
                ),
                version = "1.0.0"
        ),
        servers = {
                @Server(
                        description = "Dev",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Test",
                        url = "http://localhost:8080"
                )
        }
)
@Configuration
public class OpenApiConfig {
}
