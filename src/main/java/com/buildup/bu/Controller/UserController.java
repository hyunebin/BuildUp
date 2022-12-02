package com.buildup.bu.Controller;

import com.buildup.bu.Model.User.SignIn;
import com.buildup.bu.Model.User.SignUp;
import com.buildup.bu.Persist.Entity.Users;
import com.buildup.bu.Security.Token;
import com.buildup.bu.Service.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> userSignUp(@RequestBody SignUp signUp){
        Users users = userService.register(signUp);
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> userSignIn(@RequestBody SignIn sign){
        Token token = userService.login(sign);
        return ResponseEntity.ok().body(token);
    }

    @GetMapping("/test")
    public String index() {
        return "Hello World";
    }




}
