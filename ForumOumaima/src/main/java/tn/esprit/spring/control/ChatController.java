package tn.esprit.spring.control;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.esprit.spring.entity.ChatMessage;

//The chat message-handling Controller
@Controller
public class ChatController {
 // mapped to handle chat messages to the /send/message destination
 @MessageMapping("/send/message")
 // the return value is broadcast to all subscribers of /message
 @SendTo("/message")
 @CrossOrigin(origins = "http://localhost:4200")
 public ChatMessage chat(ChatMessage message) throws Exception {
     Thread.sleep(1000); // simulated delay
     return new ChatMessage(message.getText(), message.getUsername(), message.getAvatar());
 }
}