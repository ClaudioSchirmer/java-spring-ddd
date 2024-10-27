package br.dev.schirmer.ddd.application.commands;

import br.dev.schirmer.ddd.application.dtos.UserResponseDTO;
import br.dev.schirmer.ddd.application.pipeline.Command;

public record InsertUserCommand(
        String firstName,
        String lastName,
        String email,
        String phoneNumber
) implements Command<UserResponseDTO> {
}
