package br.com.adriankich.user_management.controller;

import br.com.adriankich.user_management.dto.UsuarioDTO;
import br.com.adriankich.user_management.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @PostMapping
    public void inserir(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.inserir(usuarioDTO);
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> alterar(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.alterar(usuarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
