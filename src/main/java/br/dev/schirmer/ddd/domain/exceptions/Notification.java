package br.dev.schirmer.ddd.domain.exceptions;

public record Notification(
   String fieldName,
   String notification
) {}
