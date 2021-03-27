package com.github.mosinpower.kubercrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class KuberCrudApplication {

    public static void main(String[] args) {
        new SpringApplication(KuberCrudApplication.class).run(args);
    }

}
