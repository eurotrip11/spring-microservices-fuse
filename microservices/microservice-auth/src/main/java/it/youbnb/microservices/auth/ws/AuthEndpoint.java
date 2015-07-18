package it.youbnb.microservices.auth.ws;

import it.youbnb.microservices.auth.api.APIAuth;
import it.youbnb.microservices.auth.services.AuthService;
import it.youbnb.ws.auth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AuthEndpoint implements APIAuth {

    private static final String NAMESPACE_URI = "http://ws.youbnb.it/auth";

    @Autowired
    private AuthService authService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginRequest")
    @ResponsePayload
    public LoginResponse login(@RequestPayload LoginRequest request) {
        return authService.login(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "logoutRequest")
    @ResponsePayload
    public LogoutResponse logout(LogoutRequest request) {
        return authService.logout(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createLoginRequest")
    @ResponsePayload
    public CreateLoginResponse created(CreateLoginRequest request) {
        return authService.created(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "activated")
    @ResponsePayload
    public ActivatedLoginResponse activated(ActivatedLoginRequest request) {
        return authService.activated(request);
    }
}
