package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s05.t01.n03.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Flower",
                version = "1.0.0",
                description = "Sprint 5, tasca 1, nivell 3"
        )
)
public class OpenApiConfig {
}
