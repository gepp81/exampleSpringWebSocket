package ar.com.gep.websocket;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import ar.com.gep.websocket.config.AppConfiguration;
import ar.com.gep.websocket.config.WebAppConfiguration;
import ar.com.gep.websocket.config.WebSocketAppConfiguration;

/**
 * 
 * @author Guillermo Pi Dote
 *
 */
public class ExampleApp extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] { AppConfiguration.class, WebAppConfiguration.class, WebSocketAppConfiguration.class };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return null;
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}
