package br.com.adriankich.user_management.controller;

import br.com.adriankich.user_management.dto.AuthenticationDTO;
import br.com.adriankich.user_management.dto.UsuarioDTO;
import br.com.adriankich.user_management.service.AuthService;
import br.com.adriankich.user_management.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authenticationDTO) {
        return ResponseEntity.ok(authService.login(authenticationDTO));
    }

    @PostMapping(value = "/cadastro")
    public ResponseEntity<?> cadastrar(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.cadastrar(usuarioDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/verificar/{uuid}")
    public String verificarCadastro(@PathVariable("uuid") String uuid) {
        usuarioService.verificarCadastro(uuid);
        return null;
    }
}
