package com.xujm.learn.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TestController {
    @GetMapping("/test")
    public Mono<String> test() {
        return Mono.just("success");
    }

    public static void main(String[] args) {
        Flux.just("tom", "jack", "allen")
                .map(s -> s.concat("@qq.com"))
                .subscribe(System.out::println);
    }
}
