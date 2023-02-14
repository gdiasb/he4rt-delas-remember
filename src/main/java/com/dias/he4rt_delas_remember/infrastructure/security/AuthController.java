package com.dias.he4rt_delas_remember.infrastructure.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthController {

    @GetMapping("/login")
    public String getLogin() {
        return "Login";
    }
}
