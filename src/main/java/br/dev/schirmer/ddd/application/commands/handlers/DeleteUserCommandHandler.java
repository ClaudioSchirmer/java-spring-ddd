package br.dev.schirmer.ddd.application.commands.handlers;

import br.dev.schirmer.ddd.application.commands.DeleteUserCommand;
import br.dev.schirmer.ddd.application.exceptions.ApplicationNotificationException;
import br.dev.schirmer.ddd.application.pipeline.Handler;
import br.dev.schirmer.ddd.domain.entities.User;
import br.dev.schirmer.ddd.domain.entities.UserRepository;
import br.dev.schirmer.ddd.domain.exceptions.NotificationException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class DeleteUserCommandHandler implements Handler<Void, DeleteUserCommand> {
    private final UserRepository userRepository;

    public DeleteUserCommandHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Void invoke(DeleteUserCommand request) throws NotificationException {
        User user = userRepository.findById(request.uuid());
        if (user == null) {
            throw new ApplicationNotificationException();
        }
        userRepository.delete(user.getDeletable());
        return null;
    }
}
