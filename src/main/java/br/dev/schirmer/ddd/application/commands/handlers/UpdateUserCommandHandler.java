package br.dev.schirmer.ddd.application.commands.handlers;

import br.dev.schirmer.ddd.application.commands.UpdateUserCommand;
import br.dev.schirmer.ddd.application.dtos.UserResponseDTO;
import br.dev.schirmer.ddd.application.exceptions.ApplicationNotificationException;
import br.dev.schirmer.ddd.application.pipeline.Handler;
import br.dev.schirmer.ddd.domain.entities.User;
import br.dev.schirmer.ddd.domain.exceptions.NotificationException;
import br.dev.schirmer.ddd.domain.valueobjects.Email;
import br.dev.schirmer.ddd.domain.valueobjects.Name;
import br.dev.schirmer.ddd.domain.valueobjects.PhoneNumber;
import br.dev.schirmer.ddd.infrastructure.repositories.UserRepositoryImpl;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class UpdateUserCommandHandler implements Handler<UserResponseDTO, UpdateUserCommand> {
    private final UserRepositoryImpl userRepositoryImpl;

    public UpdateUserCommandHandler(UserRepositoryImpl userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }

    @Override
    public UserResponseDTO invoke(UpdateUserCommand request) throws NotificationException {
        User user = userRepositoryImpl.findById(request.uuid());
        if (user == null) {
            throw new ApplicationNotificationException();
        }
        if (request.firstName() != null) {
            user.setFirstName(new Name(request.firstName()));
        }
        if (request.lastName() != null) {
            user.setLastName(new Name(request.lastName()));
        }
        if (request.email() != null) {
            user.setEmail(new Email(request.email()));
        }
        if (request.phoneNumber() != null) {
            user.setPhoneNumber(new PhoneNumber(request.phoneNumber()));
        }
        userRepositoryImpl.update(user.getUpdatable());
        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getFirstName().value(),
                user.getLastName().value(),
                user.getEmail().value(),
                user.getPhoneNumber().value()
        );
    }
}
