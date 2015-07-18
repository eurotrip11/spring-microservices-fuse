package it.youbnb.microservices.auth.controllers;

import it.youbnb.microservices.auth.api.APIAuth;
import it.youbnb.microservices.auth.services.AuthService;
import it.youbnb.ws.auth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AuthController implements APIAuth {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public LoginResponse login(@RequestBody @Valid LoginRequest request){
        return null;
    }

    @RequestMapping(value = "/auth/logout", method = RequestMethod.POST)
    public LogoutResponse logout(@RequestBody LogoutRequest request){
        return null;
    }

    @RequestMapping(value = "/auth/created", method = RequestMethod.POST)
    public CreateLoginResponse created(@RequestBody @Valid CreateLoginRequest request){
        return null;
    }

    @RequestMapping(value = "/auth/activated", method = RequestMethod.POST)
    public ActivatedLoginResponse activated(@RequestBody @Valid ActivatedLoginRequest request){
        return null;
    }
}
