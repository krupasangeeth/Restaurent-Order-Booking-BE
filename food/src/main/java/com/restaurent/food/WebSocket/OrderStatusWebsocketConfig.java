package com.restaurent.food.WebSocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@Configuration
@EnableWebSocket
public class OrderStatusWebsocketConfig implements WebSocketConfigurer{

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // TODO Auto-generated method stub
        registry
        .addHandler(new OrderStatusWebsocketHandler(), "/ws/orderstatus")
        .setAllowedOrigins("*");
    }
    
}
