package com.b2c.productcatalogue.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "${swagger.details.info.title}",
                version = "${swagger.details.info.version}",
                contact = @Contact(name = "${swagger.details.contact.name}", email = "${swagger.details.contact.email}"),
                termsOfService = "${swagger.details.termsOfService}")
)
public class SwaggerConfig {


}
