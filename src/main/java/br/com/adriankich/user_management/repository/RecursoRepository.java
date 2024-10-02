package br.com.adriankich.user_management.repository;

import br.com.adriankich.user_management.entity.RecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends JpaRepository<RecursoEntity, Long> {}
