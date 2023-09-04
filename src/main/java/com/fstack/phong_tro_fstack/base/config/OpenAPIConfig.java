package com.fstack.phong_tro_fstack.base.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.servers.Server;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SecurityScheme(
    name = "bearerAuth",
    description = "JWT auth description",
    scheme = "bearer",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    in = SecuritySchemeIn.HEADER
)
@Configuration
public class OpenAPIConfig {
  @Bean
  public OpenAPI customOpenAPI() {
    Info info = new Info();
    info.setTitle("OpenAPI specification - ManhBauTroi");
    info.setVersion("1.0");
    info.setContact(new Contact()
        .name("Manh Bau Troi")
        .email("xuanmanhdao2001@gmail.com")
        .url("https://www.facebook.com/daoxuanmanh2001")
    );
    info.setDescription("OpenAPI document for spring security");
    info.setLicense(new License().name("License name").url("https://some-url.com"));
    info.setTermsOfService("Terms of service");

    Server serverLocal = new Server();
    serverLocal.setDescription("Local ENV");
    serverLocal.setUrl("http://localhost:8080");
    Server serverProd = new Server();
    serverProd.setDescription("Prod ENV");
    serverProd.setUrl("https://phong-tro-fstack-logic-new-production.up.railway.app/");
    List<Server> servers = new ArrayList<>();
    servers.add(serverLocal);
    servers.add(serverProd);

    SecurityRequirement securityRequirement = new SecurityRequirement();
    securityRequirement.addList("bearerAuth");
    List<SecurityRequirement> security = new ArrayList<>();
    security.add(securityRequirement);

    OpenAPI openAPI = new OpenAPI();
    openAPI.setInfo(info);
    openAPI.setServers(servers);
    openAPI.setSecurity(security);

    return openAPI;
  }
}