package com.aiagent.plantaiagent;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(exclude = {
    DataSourceAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class
})
public class AIPlayGround {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AIPlayGround.class)
            .web(WebApplicationType.NONE) // 🔥 вимикає web контекст
            .run(args);
    }
}
