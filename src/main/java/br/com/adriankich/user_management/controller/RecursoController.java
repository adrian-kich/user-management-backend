package br.com.adriankich.user_management.controller;

import br.com.adriankich.user_management.dto.RecursoDTO;
import br.com.adriankich.user_management.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recursos")
@CrossOrigin
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public ResponseEntity<List<RecursoDTO>> listarRecursos() {
        return ResponseEntity.ok(recursoService.listarTodos());
    }

    @PostMapping
    public void inserir(@RequestBody RecursoDTO recursoDTO) {
        recursoService.inserir(recursoDTO);
    }

    @PutMapping
    public ResponseEntity<RecursoDTO> alterar(@RequestBody RecursoDTO recursoDTO) {
        return ResponseEntity.ok(recursoService.alterar(recursoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        recursoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
