package br.dev.schirmer.ddd.application.dtos;

import java.util.List;

public record UsersResponseDTO(
        List<UserResponseDTO> users
) {
}
