package org.mcallydevelops;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthenticationHandler {

    private final ObjectMapper objectMapper;
    public AuthenticationHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public AuthResponse handleAuthentication(String request) throws JsonProcessingException {
        AuthRequest authRequest =  objectMapper.readValue(request, AuthRequest.class);
        if("username".equals(authRequest.getUsername()) && "password".equals(authRequest.getPassword())) {
            return new AuthResponse("success");
        }
        return new AuthResponse("failure");
    }
}
