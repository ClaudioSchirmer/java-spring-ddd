package br.dev.schirmer.ddd.application.queries.handlers;

import br.dev.schirmer.ddd.application.pipeline.Handler;
import br.dev.schirmer.ddd.application.queries.FindUserQuery;
import br.dev.schirmer.ddd.application.dtos.UsersResponseDTO;
import br.dev.schirmer.ddd.infrastructure.repositories.UserQueriesRepositoryImpl;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


@Service
@Lazy
public class FindUserQueryHandler implements Handler<UsersResponseDTO, FindUserQuery> {

    private final UserQueriesRepositoryImpl userQueriesImpl;

    public FindUserQueryHandler(UserQueriesRepositoryImpl userQueriesImpl) {
        this.userQueriesImpl = userQueriesImpl;
    }

    @Override
    public UsersResponseDTO invoke(FindUserQuery request) {
        return new UsersResponseDTO(userQueriesImpl.findAll());
    }
}
