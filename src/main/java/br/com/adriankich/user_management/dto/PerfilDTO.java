package br.com.adriankich.user_management.dto;

import br.com.adriankich.user_management.entity.PerfilEntity;
import br.com.adriankich.user_management.entity.RecursoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class PerfilDTO {

    private Long id;
    private String descricao;

    public PerfilDTO(PerfilEntity perfil) {
        BeanUtils.copyProperties(perfil, this);
    }
}
