package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.event.OneSecEventListener;

@Controller
public class EventController {
    private final OneSecEventListener eventListener;

    public EventController(OneSecEventListener eventListener) {
        this.eventListener = eventListener;
    }

    @GetMapping("/event")
    public String event(Model model) {
        int count = eventListener.getCount();
        model.addAttribute("count", count);
        return "eventView";
    }

}
