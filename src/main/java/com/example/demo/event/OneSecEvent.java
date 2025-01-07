package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

public class OneSecEvent extends ApplicationEvent {
  public OneSecEvent(Object source){
    super(source);
  }
}

