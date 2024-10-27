package br.com.adriankich.user_management.repository;

import br.com.adriankich.user_management.entity.UsuarioEntity;
import br.com.adriankich.user_management.entity.UsuarioVerificadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioVerificadorRepository extends JpaRepository<UsuarioVerificadorEntity, Long> {

    Optional<UsuarioVerificadorEntity> findByUuid(UUID uuid);
}
