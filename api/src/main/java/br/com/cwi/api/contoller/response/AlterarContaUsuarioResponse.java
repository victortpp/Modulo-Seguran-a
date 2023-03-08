package br.com.cwi.api.contoller.response;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AlterarContaUsuarioResponse {

    private String nome;

    private String telefone;

    private String urlImagem;

    private LocalDateTime atualizadoEm;
}
