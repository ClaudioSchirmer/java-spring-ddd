package br.dev.schirmer.ddd.application.queries;

import br.dev.schirmer.ddd.application.dtos.UserResponseDTO;

import java.util.List;
import java.util.UUID;

public interface UserQueriesRepository {
    UserResponseDTO findById(UUID id);
    List<UserResponseDTO> findAll();
}
