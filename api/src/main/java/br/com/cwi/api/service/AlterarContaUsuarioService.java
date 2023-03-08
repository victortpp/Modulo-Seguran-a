package br.com.cwi.api.service;

import br.com.cwi.api.contoller.request.AlterarContaUsuarioRequest;
import br.com.cwi.api.contoller.response.AlterarContaUsuarioResponse;
import br.com.cwi.api.mapper.AlterarContaUsuarioMapper;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AlterarContaUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public AlterarContaUsuarioResponse alterar(AlterarContaUsuarioRequest request) {
        Usuario usuarioAutentificado = usuarioAutenticadoService.get();

        usuarioAutentificado.alterar(request);

        usuarioRepository.save(usuarioAutentificado);

        return AlterarContaUsuarioMapper.toResponse(usuarioAutentificado);
    }
}
