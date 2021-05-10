package com.github.mosinpower.kubercrud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@Slf4j
@SpringBootApplication
@EnableOpenApi
public class KuberCrudApplication {

    public static void main(String[] args) {
        new SpringApplication(KuberCrudApplication.class).run(args);
    }

}
