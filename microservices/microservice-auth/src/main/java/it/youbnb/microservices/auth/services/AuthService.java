package it.youbnb.microservices.auth.services;

import it.youbnb.microservices.auth.api.APIAuth;
import it.youbnb.microservices.auth.exceptions.AccountNotActivedException;
import it.youbnb.microservices.auth.exceptions.LoginException;
import it.youbnb.microservices.auth.model.Login;
import it.youbnb.microservices.auth.repositories.LoginRepository;
import it.youbnb.ws.auth.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class AuthService implements APIAuth {
    @Autowired
    private LoginRepository loginRepository;

    public LoginResponse login(LoginRequest request) {
        Login loginDB = loginRepository.findByEmail(request.getEmail());
        if (loginDB == null){
            throw new LoginException();
        }
        if (!loginDB.isActived()){
            throw new AccountNotActivedException();
        }
        if (!loginDB.getPassword().equalsIgnoreCase(request.getPassword())){
            throw new LoginException();
        }
        LoginResponse response = new LoginResponse();
        response.setCode("OK");
        response.setDescription("Success!");
        return response;
    }

    public LogoutResponse logout(LogoutRequest request) {
        LogoutResponse response = new LogoutResponse();
        response.setCode("OK");
        response.setDescription("Success!");
        return response;
    }

    public CreateLoginResponse created(CreateLoginRequest request) {
        Login loginDB = loginRepository.findByEmail(request.getEmail());
        if (loginDB != null){
            throw new LoginException();
        }
        Login login = new Login();
        login.setEmail(request.getEmail());
        login.setPassword(request.getPassword());
        login.setToken(UUID.randomUUID().toString());
        login.setValidAt(new DateTime().plusDays(30).toDate());
        login = loginRepository.save(login);
        CreateLoginResponse response = new CreateLoginResponse();
        response.setCode("OK");
        response.setDescription("Success!");
        response.setEmail(login.getEmail());
        response.setToken(login.getToken());
        return null;
    }

    public ActivatedLoginResponse activated(ActivatedLoginRequest request) {
        Login loginDB = loginRepository.findOne(request.getId());
        if (loginDB == null){
            throw new LoginException();
        }
        if (!loginDB.getToken().equalsIgnoreCase(request.getToken())){
            throw new LoginException();
        }
        if (loginDB.getValidAt().before(new Date())){
            throw new LoginException();
        }
        loginDB.setActived(true);
        loginRepository.save(loginDB);
        ActivatedLoginResponse response = new ActivatedLoginResponse();
        response.setCode("OK");
        response.setDescription("Success!");
        response.setToken(loginDB.getToken());
        response.setActived(true);
        response.setEmail(loginDB.getEmail());
        return response;
    }
}
