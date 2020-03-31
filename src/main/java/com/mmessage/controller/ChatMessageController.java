package com.mmessage.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mmessage.model.ChatMessageModel;
import com.mmessage.repository.ChatMessageRepository;

@Controller
public class ChatMessageController {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @GetMapping("/loginUrl")
    public String login(){

        System.out.println("Hello LoginUrl");
        return "login";
    }

    @GetMapping("/chat")
    public String chat(){

        return "chat";

    }

    @RequestMapping(value = "/messages",method = RequestMethod.POST)
    @MessageMapping("/newMessage")
    @SendTo("/topic/newMessage")
    public ChatMessageModel savechatMessage(ChatMessageModel chatMessageModel){

        ChatMessageModel chatMessageModel1 = new ChatMessageModel(chatMessageModel.getText(),chatMessageModel.getAuthor(),new Date());
        ChatMessageModel message = chatMessageRepository.save(chatMessageModel1);
        List<ChatMessageModel> chatMessageModelList = chatMessageRepository.findAll();
        System.out.println("Hell From savechatMessage");
        return message;

    }

    @RequestMapping(value = "/messages",method = RequestMethod.GET)
    public HttpEntity list(){

        List<ChatMessageModel> chatMessageModelList = chatMessageRepository.findAll();
        return  new ResponseEntity(chatMessageModelList, HttpStatus.OK);
    }

}
