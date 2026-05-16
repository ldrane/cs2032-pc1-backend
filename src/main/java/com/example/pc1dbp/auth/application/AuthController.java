package com.example.pc1dbp.auth.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO request){
        UserResponseDTO userResponseDTO = authService.register(request);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequestDTO request){
        TokenResponse tokenResponse = authService.login(request);
        return ResponseEntity.ok(tokenResponse);
    }
}
