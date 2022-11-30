package com.example.starthomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing      //타임스탬프 받아오는 기능과 관련된 어노테이션으로 추측
public class StarthomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarthomeworkApplication.class, args);
    }

}
