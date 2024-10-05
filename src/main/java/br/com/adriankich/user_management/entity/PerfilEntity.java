package br.com.adriankich.user_management.entity;

import br.com.adriankich.user_management.dto.PerfilDTO;
import br.com.adriankich.user_management.dto.RecursoDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "cmn_perfis")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PerfilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    public PerfilEntity(PerfilDTO perfilDTO) {
        BeanUtils.copyProperties(perfilDTO, this);
    }
}
