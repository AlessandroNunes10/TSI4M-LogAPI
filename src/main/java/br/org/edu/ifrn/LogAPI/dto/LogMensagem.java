package br.org.edu.ifrn.LogAPI.dto;

import java.time.LocalDateTime;

public record LogMensagem(
        LocalDateTime dataHora,
        String operacao,
        String status,
        Long usuarioId,
        String usuarioNome,
        String metodoHttp,
        String endpoint,
        String detalhes
) {}
