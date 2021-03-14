package br.com.digitalinovationone.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Getter
@Setter
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Bean
    @Profile("dev")
    public String getDevDatabaseConnection() {
        System.out.println("DB connection dor DEV - H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB connection to H2_TEST - Test instance";
    }

    @Bean
    @Profile("prod")
    public String getProdDatabaseConnection() {
        System.out.println("DB connection dor PROD - MYSQL");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB connection to MYSQL_TEST - Test instance";
    }

}
