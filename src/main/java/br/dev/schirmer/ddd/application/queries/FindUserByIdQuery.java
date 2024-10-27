package br.dev.schirmer.ddd.application.queries;

import br.dev.schirmer.ddd.application.dtos.UserResponseDTO;
import br.dev.schirmer.ddd.application.pipeline.Query;

import java.util.UUID;

public record FindUserByIdQuery(
        UUID uuid
) implements Query<UserResponseDTO> {
}
