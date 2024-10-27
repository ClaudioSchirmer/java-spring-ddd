package br.dev.schirmer.ddd.application.commands;

import br.dev.schirmer.ddd.application.dtos.UserResponseDTO;
import br.dev.schirmer.ddd.application.pipeline.Command;

import java.util.UUID;

public record UpdateUserCommand(
        UUID uuid,
        String firstName,
        String lastName,
        String email,
        String phoneNumber
) implements Command<UserResponseDTO> {
}
