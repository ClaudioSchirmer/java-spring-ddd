package br.dev.schirmer.ddd.application.pipeline;

import br.dev.schirmer.ddd.domain.exceptions.NotificationException;

public interface Handler<TResult, TRequest extends Request<TResult>> {
    TResult invoke(TRequest request) throws NotificationException;
}
