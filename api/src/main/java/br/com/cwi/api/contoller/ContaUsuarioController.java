package br.com.cwi.api.contoller;


import br.com.cwi.api.contoller.request.AlterarContaUsuarioRequest;
import br.com.cwi.api.contoller.response.AlterarContaUsuarioResponse;
import br.com.cwi.api.service.AlterarContaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/contas")
public class ContaUsuarioController {

    @Autowired
    private AlterarContaUsuarioService alterarContaUsuarioService;

    @PutMapping("/me")
    public AlterarContaUsuarioResponse alterar(@Valid @RequestBody AlterarContaUsuarioRequest request) {
        return alterarContaUsuarioService.alterar(request);
    }

}
