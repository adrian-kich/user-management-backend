package br.com.adriankich.user_management.service;

import br.com.adriankich.user_management.dto.UsuarioDTO;
import br.com.adriankich.user_management.entity.UsuarioEntity;
import br.com.adriankich.user_management.entity.enums.TipoSituacaoUsuario;
import br.com.adriankich.user_management.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    public List<UsuarioDTO> listarTodos() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDTO::new).toList();
    }

    public UsuarioDTO buscarPorId(Long id) {
        return new UsuarioDTO(usuarioRepository.findById(id).get());
    }

    public void inserir(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        usuarioEntity.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        usuarioRepository.save(usuarioEntity);
    }

    public void cadastrar(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        usuarioEntity.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        usuarioEntity.setSituacao(TipoSituacaoUsuario.PENDENTE);
        usuarioEntity.setId(null);
        usuarioRepository.save(usuarioEntity);

        emailService.enviarEmailTexto(usuarioDTO.getEmail(),
                "Verificação de cadastro",
                "Você esta recebendo um email para verificar o cadastro");
    }

    public UsuarioDTO alterar(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        usuarioEntity.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
    }

    public void excluir(Long id) {
        UsuarioEntity usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }
}
