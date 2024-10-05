package br.com.adriankich.user_management.entity;

import br.com.adriankich.user_management.dto.PerfilDTO;
import br.com.adriankich.user_management.dto.PerfilUsuarioDTO;
import br.com.adriankich.user_management.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "cmn_perfil_usuario")
@Getter
@Setter
@NoArgsConstructor
public class PerfilUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private PerfilEntity perfil;

    public PerfilUsuarioEntity(PerfilUsuarioDTO perfilUsuarioDTO) {
        BeanUtils.copyProperties(perfilUsuarioDTO, this);
        if(perfilUsuarioDTO != null && perfilUsuarioDTO.getUsuario() != null) {
            this.usuario = new UsuarioEntity(perfilUsuarioDTO.getUsuario());
        }
        if(perfilUsuarioDTO != null && perfilUsuarioDTO.getPerfil() != null) {
            this.perfil = new PerfilEntity(perfilUsuarioDTO.getPerfil());
        }
    }
}
