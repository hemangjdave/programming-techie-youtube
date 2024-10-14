package com.techrevolution.ms.apigateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.HandlerFunction;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class ApiRoutes {

    @Bean
    public RouterFunction<ServerResponse> productServiceRoutes() {
        HandlerFunction<ServerResponse> handlerFunction = HandlerFunctions.http("http://localhost:8080");
        return GatewayRouterFunctions.route()
                .route(RequestPredicates.GET("/api/product"), handlerFunction)
                .route(RequestPredicates.POST("/api/product"), handlerFunction)
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> orderServiceRoutes() {
        HandlerFunction<ServerResponse> handlerFunction = HandlerFunctions.http("http://localhost:8081");
        return GatewayRouterFunctions.route()
                .route(RequestPredicates.POST("/api/order"), handlerFunction)
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceRoutes() {
        HandlerFunction<ServerResponse> handlerFunction = HandlerFunctions.http("http://localhost:8082");
        return GatewayRouterFunctions.route()
                .route(RequestPredicates.GET("/api/inventory"), handlerFunction)
                .build();
    }

}
