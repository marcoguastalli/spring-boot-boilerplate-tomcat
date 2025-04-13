package net.marco27.java.boilerplate.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("web")
public class AppYmlConfig {

    private String version;

}
