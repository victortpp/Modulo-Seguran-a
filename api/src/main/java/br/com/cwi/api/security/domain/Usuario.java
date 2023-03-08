package br.com.cwi.api.security.domain;

import br.com.cwi.api.contoller.request.AlterarContaUsuarioRequest;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private String urlImagem;
    private String email;
    private String senha;
    private boolean ativo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();

    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuario(this);
    }

    public void alterar(AlterarContaUsuarioRequest request) {
        this.setNome(request.getNome());
        this.setTelefone(request.getTelefone());
        this.setUrlImagem(request.getUrlImagem());
        this.setAtualizadoEm(LocalDateTime.now());
    }
}
