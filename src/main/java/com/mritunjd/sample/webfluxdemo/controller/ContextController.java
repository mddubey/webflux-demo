package com.mritunjd.sample.webfluxdemo.controller;

import com.mritunjd.sample.webfluxdemo.service.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.util.context.ContextView;

import java.util.function.Function;

@RestController
public class ContextController {
    @Autowired
    ContextService contextService;

    @GetMapping("/test")
    public Mono<String> testContext(@RequestParam String id){
        return contextService.printContextData(id);
    }
}
