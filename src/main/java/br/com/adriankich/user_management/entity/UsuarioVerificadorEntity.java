package br.com.adriankich.user_management.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "cmn_usuarios_verificador")
public class UsuarioVerificadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private UUID uuid;

    @Column(nullable = false)
    private Instant dataExpiracao;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", unique = true)
    private UsuarioEntity usuario;
}
