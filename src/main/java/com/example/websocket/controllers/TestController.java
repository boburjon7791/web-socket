package com.example.websocket.controllers;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.val;

@Controller
@RequiredArgsConstructor
public class TestController {
    private String message="Salom";
    private final SimpMessagingTemplate simpMessagingTemplate;
    @GetMapping("")
	public String test(Model model){
		model.addAttribute("value",message);
		return "index";
	}
	@PostMapping("/set")
	public String setValue(@RequestParam("param")String param,HttpServletResponse response)throws Exception{
		this.message=param;
        simpMessagingTemplate.convertAndSend("/test/start", param);
		return "set";
	}
	@GetMapping("/set")
	public String setValue(){
		return "set";
	}
}
