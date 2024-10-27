package br.dev.schirmer.ddd.application.exceptions;

import br.dev.schirmer.ddd.domain.exceptions.Notification;
import br.dev.schirmer.ddd.domain.exceptions.NotificationException;

import java.util.List;

public class ApplicationNotificationException extends NotificationException {

    public ApplicationNotificationException(List<Notification> notifications) {
        super(notifications);
    }

    public ApplicationNotificationException() {
        super(null);
    }

}