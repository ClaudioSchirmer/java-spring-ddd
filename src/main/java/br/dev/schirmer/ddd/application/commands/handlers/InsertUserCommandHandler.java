package br.dev.schirmer.ddd.application.commands.handlers;

import br.dev.schirmer.ddd.application.commands.InsertUserCommand;
import br.dev.schirmer.ddd.application.dtos.UserResponseDTO;
import br.dev.schirmer.ddd.application.pipeline.Handler;
import br.dev.schirmer.ddd.domain.ValidEntity;
import br.dev.schirmer.ddd.domain.entities.User;
import br.dev.schirmer.ddd.domain.exceptions.NotificationException;
import br.dev.schirmer.ddd.infrastructure.repositories.UserRepositoryImpl;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class InsertUserCommandHandler implements Handler<UserResponseDTO, InsertUserCommand> {
    private final UserRepositoryImpl userRepositoryImpl;

    public InsertUserCommandHandler(UserRepositoryImpl userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }

    @Override
    public UserResponseDTO invoke(InsertUserCommand command) throws NotificationException {
        User user = new User(
                command.firstName(),
                command.lastName(),
                command.email(),
                command.phoneNumber()
        );
        ValidEntity.Insertable<User> insertable = user.getInsertable();
        return new UserResponseDTO(
                userRepositoryImpl.insertUser(insertable),
                user.getUsername(),
                user.getFirstName().value(),
                user.getLastName().value(),
                user.getEmail().value(),
                user.getPhoneNumber().value()
        );
    }
}