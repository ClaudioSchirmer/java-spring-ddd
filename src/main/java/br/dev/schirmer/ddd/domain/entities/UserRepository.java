package br.dev.schirmer.ddd.domain.entities;

import br.dev.schirmer.ddd.domain.ValidEntity;
import br.dev.schirmer.ddd.domain.exceptions.NotificationException;

import java.util.UUID;

public interface UserRepository {
    UUID insertUser(ValidEntity.Insertable<User> user) throws NotificationException;

    User findById(UUID uuid) throws NotificationException;

    void delete(ValidEntity.Deletable<User> user) throws NotificationException;

    void update(ValidEntity.Updatable<User> user) throws NotificationException;
}
