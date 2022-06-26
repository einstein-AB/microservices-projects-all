package com.springboot.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping ("/fallback")
public class FallbackController {

    @RequestMapping ("/schoolInfo")
    public Mono<String> schoolInfoFallback() {
        return Mono.just("SchoolInfo Service is taking too long to respond. Please try again later");
    }

    @RequestMapping ("/studentInfo")
    public Mono<String> studentInfoFallback() {
        return Mono.just("Student Info Service is taking too long to respond. Please try again later");
    }

    @RequestMapping ("/staffInfo")
    public Mono<String> staffInfoFallback() {
        return Mono.just("Staff Info Service is taking too long to respond. Please try again later");
    }
}
