package com.buildup.bu.Controller;

import com.buildup.bu.Model.User.SignUp;
import com.buildup.bu.Persist.Entity.Users;
import com.buildup.bu.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
}
