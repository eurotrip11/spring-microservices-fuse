package it.youbnb.microservices.auth.api;

import it.youbnb.ws.auth.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

public interface APIAuth {
    LoginResponse login(LoginRequest request);
    LogoutResponse logout(LogoutRequest request);
    CreateLoginResponse created(CreateLoginRequest request);
    ActivatedLoginResponse activated(ActivatedLoginRequest request);
}
