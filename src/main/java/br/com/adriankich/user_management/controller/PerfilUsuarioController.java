package br.com.adriankich.user_management.controller;

import br.com.adriankich.user_management.dto.PerfilUsuarioDTO;
import br.com.adriankich.user_management.service.PerfilService;
import br.com.adriankich.user_management.service.PerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/perfil-usuario")
@CrossOrigin
public class PerfilUsuarioController {

    @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    @GetMapping
    public ResponseEntity<List<PerfilUsuarioDTO>> listarPerfis() {
        return ResponseEntity.ok(perfilUsuarioService.listarTodos());
    }

    @PostMapping
    public void inserir(@RequestBody PerfilUsuarioDTO perfilUsuarioDTO) {
        perfilUsuarioService.inserir(perfilUsuarioDTO);
    }

    @PutMapping
    public ResponseEntity<PerfilUsuarioDTO> alterar(@RequestBody PerfilUsuarioDTO perfilUsuarioDTO) {
        return ResponseEntity.ok(perfilUsuarioService.alterar(perfilUsuarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        perfilUsuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
