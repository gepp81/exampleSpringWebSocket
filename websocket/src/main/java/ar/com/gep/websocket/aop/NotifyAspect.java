package ar.com.gep.websocket.aop;

import java.util.Date;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import ar.com.gep.websocket.annotation.NotifyClient;

/**
 * 
 * @author Guillermo Pi Dote
 *
 */
@Aspect
public class NotifyAspect {

  private class MessageDTO {
    private Date date;
    private String action;

    public MessageDTO(String action) {
      this.date = new Date();
      this.action = action;
    }

    public Date getDate() {
      return date;
    }

    public String getAction() {
      return action;
    }

    public void setAction(String action) {
      this.action = action;
    }
  }

  @Autowired
  private SimpMessagingTemplate template;

  private static final String WEBSOCKET = "/topic/";

  @After("@annotation(notifyClient)")
  public void notifyClient(final NotifyClient notifyClient) throws Throwable {
    if (notifyClient.topic() != null) {
      template.convertAndSend(WEBSOCKET.concat(notifyClient.topic()), new MessageDTO(notifyClient.action()));
    }
  }

}