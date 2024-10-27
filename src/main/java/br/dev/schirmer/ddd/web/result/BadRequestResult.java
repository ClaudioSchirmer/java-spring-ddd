package br.dev.schirmer.ddd.web.result;

import br.dev.schirmer.ddd.domain.exceptions.Notification;

import java.util.List;

public record BadRequestResult(
        List<Notification> notifications
) {
}
