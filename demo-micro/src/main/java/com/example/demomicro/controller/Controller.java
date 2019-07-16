package com.example.demomicro.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class Controller {

    @GetMapping(value = "/test")
    private Mono<String> test() {
        return Mono.just("test1");
    }

    @GetMapping(value = "/headers")
    private Mono<Map<String, String>> headers(ServerWebExchange exchange) {
        return Mono.justOrEmpty(exchange.getRequest().getHeaders().toSingleValueMap());
    }

}
