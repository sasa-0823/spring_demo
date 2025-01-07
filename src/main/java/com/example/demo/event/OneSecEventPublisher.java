package com.example.demo.event;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@EnableCaching
public class OneSecEventPublisher {
  private final ApplicationEventPublisher applicationEventPublisher;

  @Scheduled(fixedRate = 1000)
  public void publishOneSecEvent(){
    OneSecEvent event = new OneSecEvent(this);
    applicationEventPublisher.publishEvent(event);
  }
}
