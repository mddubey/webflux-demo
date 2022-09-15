package com.mritunjd.sample.webfluxdemo.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class ContextFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String id = exchange.getRequest().getQueryParams().get("id").get(0);
        return chain.filter(exchange)
                .contextWrite(ctx -> {
                    ctx = ctx.put("IP Address", id + ".123.23.43");
                    ctx = ctx.put("Location", id + "-Street");
                    return ctx;
                });
    }
}
