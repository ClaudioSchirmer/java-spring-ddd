package br.dev.schirmer.ddd.application.pipeline;

import br.dev.schirmer.ddd.domain.exceptions.NotificationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class Pipeline {
    private final Map<String, Handler<?, ?>> handlerMap;

    @Autowired
    public Pipeline(Map<String, Handler<?, ?>> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public <TResult, TRequest extends Request<TResult>> Result<?> dispatch(TRequest request) {
        try {
            return new Result.Success<>(getHandler(request).invoke(request));
        } catch (NotificationException e) {
            return new Result.Failure(e.getNotifications());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Result.Exception(e);
        }
    }

    @SuppressWarnings("unchecked")
    private <TResult, TRequest extends Request<TResult>> Handler<TResult, TRequest> getHandler(TRequest request) {
        String className = request.getClass().getSimpleName();
        String handlerKey = className.substring(0, 1).toLowerCase() + className.substring(1) + "Handler";
        return (Handler<TResult, TRequest>) handlerMap.get(handlerKey);
    }

}
