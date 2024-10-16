package com.restaurent.food.WebSocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderStatusWebsocketHandler extends TextWebSocketHandler{

    // private List<WebSocketSession> sessions = new ArrayList<>();
    private Map<Long, WebSocketSession> sessionsMap = new HashMap<>();

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // TODO Auto-generated method stub
        log.info("Websocket connection closed" + session.toString());
        // sessions.remove(session);
        Long mobile =  Long.parseLong(session.getUri().getQuery().split("=")[1]);
        sessionsMap.remove(mobile);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // TODO Auto-generated method stub
        
        // sessions.add(session);
        Long mobile =  Long.parseLong(session.getUri().getQuery().split("=")[1]);
        sessionsMap.put(mobile, session);
        log.info("Websocket connection established" + session.toString());
        // System.out.println("Websocket connection established" + session.toString());

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // TODO Auto-generated method stub
        log.info("message received" + message.getPayload());
        ObjectMapper mapper = new ObjectMapper();
        WebSocketstatusMessage data = mapper.readValue(message.getPayload(), WebSocketstatusMessage.class);
        log.info(data.toString());
        sessionsMap.get(data.getMobile()).sendMessage(message);
        // System.out.println("message received" + message.getPayload());
        // sessions.forEach((sess) -> sess.sendMessage(message));
        // for(WebSocketSession sess : sessions) {
        //     sess.sendMessage(message);
        // }


    }
   
}

@Data
class WebSocketstatusMessage {
    private Long mobile;
    private String status;
    private Long orderItemId;
}
