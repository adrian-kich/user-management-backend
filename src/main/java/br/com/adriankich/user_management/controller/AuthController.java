package br.com.adriankich.user_management.controller;

import br.com.adriankich.user_management.dto.AuthenticationDTO;
import br.com.adriankich.user_management.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authenticationDTO) {
        return ResponseEntity.ok(authService.login(authenticationDTO));
    }

}
