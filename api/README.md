
# Projeto Modulo Segurança

Tentando implementar no codigo métodos mostrados em aula


## Requisitos

- Java 11
- Postgres instalado



## Instalação

### BANCO DE DADOS
rode esse scritp no banco
```bash
DROP TABLE IF EXISTS permissao CASCADE;
DROP TABLE IF EXISTS usuario CASCADE;

CREATE TABLE usuario (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	nome VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	telefone VARCHAR(50),
	criado_em TIMESTAMP NOT NULL,
	atualizado_em TIMESTAMP,
	senha VARCHAR(128) NOT NULL,
	url_imagem VARCHAR(512),
	ativo BOOLEAN NOT NULL
);
ALTER TABLE usuario ADD CONSTRAINT pk_usuario PRIMARY KEY (id);
ALTER TABLE usuario ADD CONSTRAINT uk_usuario_email UNIQUE (email);

CREATE TABLE permissao (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	nome VARCHAR(100) NOT NULL,
	usuario_id BIGINT NOT NULL
);
ALTER TABLE permissao ADD CONSTRAINT pk_permissao PRIMARY KEY (id);
ALTER TABLE permissao ADD CONSTRAINT uk_permissao UNIQUE (nome, usuario_id);
ALTER TABLE permissao ADD CONSTRAINT fk_permissao_usuario FOREIGN KEY (usuario_id) REFERENCES usuario;

INSERT INTO usuario(nome, email, telefone, criado_em, senha, url_imagem, ativo) VALUES('teste', 'teste@teste.com.br','999999', '2023-03-08 10:00:00', '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', 'https://img.freepik.com/vetores-premium/homem-perfil-caricatura_18591-58482.jpg?w=2000', true);
INSERT INTO permissao (nome, usuario_id) VALUES ('USUARIO', 1);
```
## Api
```bash
utilizar o postman para testar os metodos.
importar o arquivo postman na pasta data localizada na raiz do projeto.
```
### APP VSCODE
rode no terminal esses comandos

```bash
  npm install 
  npm start
```
### APLICAÇÃO FRONT LOGIN
login ja criado por padrão

```bash
  email: teste@teste.com.br
  senha: 123456
```
    
