package ar.com.gep.websocket.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import ar.com.gep.websocket.annotation.NotifyClient;

@Aspect
public class NotifyAspect {

  @Autowired
  private SimpMessagingTemplate template;

  private static final String WEBSOCKET = "/topic/";

  @After("@annotation(notifyClient)")
  public void notifyClient(NotifyClient notifyClient) throws Throwable {
    if (notifyClient.topic() != null) {
      template.convertAndSend(WEBSOCKET, new Date());
    }
  }
  
}