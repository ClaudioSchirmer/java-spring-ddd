package br.dev.schirmer.ddd.web.result;

public record SuccessResult<TResult>(
        TResult data
){}