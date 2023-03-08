package br.com.cwi.api.mapper;

import br.com.cwi.api.contoller.response.AlterarContaUsuarioResponse;
import br.com.cwi.api.security.domain.Usuario;

public class AlterarContaUsuarioMapper {
    public static AlterarContaUsuarioResponse toResponse(Usuario usuarioAutentificado) {
        return AlterarContaUsuarioResponse.builder()
                .nome(usuarioAutentificado.getNome())
                .telefone(usuarioAutentificado.getTelefone())
                .urlImagem(usuarioAutentificado.getUrlImagem())
                .atualizadoEm(usuarioAutentificado.getAtualizadoEm())
                .build();
    }
}
