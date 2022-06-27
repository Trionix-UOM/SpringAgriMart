package com.trionix.agrimartorder.controller;

import com.trionix.agrimartorder.dto.SignupDto;
import com.trionix.agrimartorder.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<String> signup(@Valid @RequestBody SignupDto body)
    {
        String register = authenticationService.register(body);
        return ResponseEntity.ok(register);
    }
}

