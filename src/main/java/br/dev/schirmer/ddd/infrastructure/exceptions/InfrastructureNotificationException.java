package br.dev.schirmer.ddd.infrastructure.exceptions;

import br.dev.schirmer.ddd.domain.exceptions.Notification;
import br.dev.schirmer.ddd.domain.exceptions.NotificationException;

import java.util.List;

public class InfrastructureNotificationException extends NotificationException {

    public InfrastructureNotificationException(List<Notification> notifications) {
        super(notifications);
    }

}
