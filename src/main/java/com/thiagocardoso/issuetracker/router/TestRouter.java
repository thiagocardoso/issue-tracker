package com.thiagocardoso.issuetracker.router;

import com.thiagocardoso.issuetracker.handler.TestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class TestRouter {

    @Bean
    public RouterFunction<ServerResponse> routeTest(TestHandler handler) {
        return RouterFunctions
                .route(
                        RequestPredicates.GET("/test").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        handler::testHandler
                );
    }
}
