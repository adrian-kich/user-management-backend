package br.com.adriankich.user_management.service;

import br.com.adriankich.user_management.dto.RecursoDTO;
import br.com.adriankich.user_management.dto.UsuarioDTO;
import br.com.adriankich.user_management.entity.RecursoEntity;
import br.com.adriankich.user_management.entity.UsuarioEntity;
import br.com.adriankich.user_management.repository.RecursoRepository;
import br.com.adriankich.user_management.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoService {

    @Autowired
    private RecursoRepository recursoRepository;

    public List<RecursoDTO> listarTodos() {
        List<RecursoEntity> recursos = recursoRepository.findAll();
        return recursos.stream().map(RecursoDTO::new).toList();
    }

    public RecursoDTO buscarPorId(Long id) {
        return new RecursoDTO(recursoRepository.findById(id).get());
    }

    public void inserir(RecursoDTO recursoDTO) {
        RecursoEntity recursoEntity = new RecursoEntity(recursoDTO);
        recursoRepository.save(recursoEntity);
    }

    public RecursoDTO alterar(RecursoDTO recursoDTO) {
        RecursoEntity recursoEntity = new RecursoEntity(recursoDTO);
        return new RecursoDTO(recursoRepository.save(recursoEntity));
    }

    public void excluir(Long id) {
        RecursoEntity recurso = recursoRepository.findById(id).get();
        recursoRepository.delete(recurso);
    }
}
