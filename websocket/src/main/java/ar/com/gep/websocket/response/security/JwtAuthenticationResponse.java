package ar.com.gep.websocket.response.security;

import java.io.Serializable;

/**
 * 
 * @author Guillermo Pi Dote
 */
public class JwtAuthenticationResponse implements Serializable {

  private static final long serialVersionUID = 1250166508152483573L;

  private final String token;

  public JwtAuthenticationResponse(String token) {
    this.token = token;
  }

  public String getToken() {
    return this.token;
  }
}
