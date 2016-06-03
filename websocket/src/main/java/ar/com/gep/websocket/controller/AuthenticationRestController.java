package ar.com.gep.websocket.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.gep.websocket.config.security.JwtAuthenticationRequest;
import ar.com.gep.websocket.config.security.JwtTokenUtil;
import ar.com.gep.websocket.response.security.JwtAuthenticationResponse;

/**
 * 
 * @author Guillermo Pi Dote
 */
@RestController
public class AuthenticationRestController {

  @Value("${jwt.header}")
  private String tokenHeader;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private UserDetailsService userDetailsService;

  @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest)
      throws AuthenticationException {

    // Perform the security
    final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        authenticationRequest.getUsername(), authenticationRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);

    // Reload password post-security so we can generate token
    final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
    final String token = jwtTokenUtil.generateToken(userDetails);

    // Return the token
    return ResponseEntity.ok(new JwtAuthenticationResponse(token));
  }

  @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
  public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
    String token = request.getHeader(tokenHeader);

    if (jwtTokenUtil.canTokenBeRefreshed(token)) {
      String refreshedToken = jwtTokenUtil.refreshToken(token);
      return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
    } else {
      return ResponseEntity.badRequest().body(null);
    }
  }

}