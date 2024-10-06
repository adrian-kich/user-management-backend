package br.com.adriankich.user_management.repository;

import br.com.adriankich.user_management.entity.PermissaoPerfilRecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoPerfilRecursoRepository extends JpaRepository<PermissaoPerfilRecursoEntity, Long> {

}
