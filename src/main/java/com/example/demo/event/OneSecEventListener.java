package com.example.demo.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class OneSecEventListener {
    private int count;

    @EventListener
    private void onOnesecEvent(OneSecEvent event){
        this.count++ ;
    }
}
