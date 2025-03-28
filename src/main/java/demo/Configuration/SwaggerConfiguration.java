


package demo.Configuration;  // Update to match your actual package structure

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cooking Portal API")
                        .version("1.0")
                        .description("API documentation for User Management in Cooking Portal"));
    }
}
