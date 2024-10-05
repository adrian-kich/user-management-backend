package br.com.adriankich.user_management.service;

import br.com.adriankich.user_management.dto.PerfilDTO;
import br.com.adriankich.user_management.entity.PerfilEntity;
import br.com.adriankich.user_management.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<PerfilDTO> listarTodos() {
        List<PerfilEntity> perfis = perfilRepository.findAll();
        return perfis.stream().map(PerfilDTO::new).toList();
    }

    public PerfilDTO buscarPorId(Long id) {
        return new PerfilDTO(perfilRepository.findById(id).get());
    }

    public void inserir(PerfilDTO perfilDTO) {
        PerfilEntity perfilEntity = new PerfilEntity(perfilDTO);
        perfilRepository.save(perfilEntity);
    }

    public PerfilDTO alterar(PerfilDTO perfilDTO) {
        PerfilEntity perfilEntity = new PerfilEntity(perfilDTO);
        return new PerfilDTO(perfilRepository.save(perfilEntity));
    }

    public void excluir(Long id) {
        PerfilEntity perfil = perfilRepository.findById(id).get();
        perfilRepository.delete(perfil);
    }
}
