package br.dev.schirmer.ddd.web.dtos;

public record UserRequestDTO(
        String firstName,
        String lastName,
        String email,
        String phoneNumber
) {
}
