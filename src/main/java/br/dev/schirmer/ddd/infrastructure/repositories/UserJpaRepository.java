package br.dev.schirmer.ddd.infrastructure.repositories;

import br.dev.schirmer.ddd.infrastructure.tables.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserTable, UUID> {
}
