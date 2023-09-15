package com.businesscard.ws.auth;

import com.businesscard.ws.shared.CurrentUser;
import com.businesscard.ws.shared.Views;
import com.businesscard.ws.user.User;
import com.businesscard.ws.user.UserRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/api/1.0/auth")
    @JsonView(Views.Base.class)
    ResponseEntity<?> handleAuthentication(@CurrentUser User user){
        return ResponseEntity.ok(user);
    }
}
