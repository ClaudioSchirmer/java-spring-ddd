package br.dev.schirmer.ddd.application.queries;

import br.dev.schirmer.ddd.application.dtos.UsersResponseDTO;
import br.dev.schirmer.ddd.application.pipeline.Query;


public record FindUserQuery() implements Query<UsersResponseDTO> {
}
