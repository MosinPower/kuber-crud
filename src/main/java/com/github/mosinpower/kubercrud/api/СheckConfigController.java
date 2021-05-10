package com.github.mosinpower.kubercrud.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Slf4j
@RequiredArgsConstructor
@RestController
public class СheckConfigController {

    @Value("${config.host}")
    private String host;
    @Value("${config.name}")
    private String name;
    @Value("${config.password}")
    private String password;


    @GetMapping(value = "/check")
    public String check() {
        return "host: " + host + " \n"
                + "name: " + name + " \n"
                + "password: " + password;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(host);
        System.out.println(name);
        System.out.println(password);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
