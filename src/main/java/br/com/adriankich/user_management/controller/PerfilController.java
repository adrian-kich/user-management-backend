package br.com.adriankich.user_management.controller;

import br.com.adriankich.user_management.dto.PerfilDTO;
import br.com.adriankich.user_management.service.PerfilService;
import br.com.adriankich.user_management.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/perfis")
@CrossOrigin
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public ResponseEntity<List<PerfilDTO>> listarPerfis() {
        return ResponseEntity.ok(perfilService.listarTodos());
    }

    @PostMapping
    public void inserir(@RequestBody PerfilDTO perfilDTO) {
        perfilService.inserir(perfilDTO);
    }

    @PutMapping
    public ResponseEntity<PerfilDTO> alterar(@RequestBody PerfilDTO perfilDTO) {
        return ResponseEntity.ok(perfilService.alterar(perfilDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        perfilService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
