package br.dev.schirmer.ddd.application.commands;

import br.dev.schirmer.ddd.application.pipeline.Command;

import java.util.UUID;

public record DeleteUserCommand(
        UUID uuid
) implements Command<Void> {
}
