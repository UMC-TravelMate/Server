package UMC.TravelMate.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {     //public api로 모든 경로를 하나의 그룹으로 결성
        return GroupedOpenApi.builder()
                .group("TravelMate")    // 그룹이름 설정
                .pathsToMatch("/**")    // 모든 경로 포함
                .build();
    }

    @Bean
    public OpenAPI openAPI() {     // open api로 API문서의 기본정보 설정
        return new OpenAPI()
                .info(new Info()
                        .title("TravelMate API")
                        .version("1.0.0"));
    }
}