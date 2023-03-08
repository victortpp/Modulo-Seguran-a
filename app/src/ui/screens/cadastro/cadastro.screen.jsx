import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../../../api/login/login.api";

const DADOS_INICIAIS = { nome: "", email: "", senha: "", telefone: "", foto:"",  permissoes: ["USUARIO"]}
export function CadastroScreen(){
    const [usuario, setUsuario] = useState(DADOS_INICIAIS)
    const auth = useAuth()
    const navigate = useNavigate()


    function handleChange({ target }) {
        const { name, value } = target;

        setUsuario((oldUserInfo) => ({ ...oldUserInfo, [name]: value }));
    }

    async function handleSubmit(event) {
        event.preventDefault();
        try {
            const user = await auth.register({
                nome: usuario.nome,
                senha: usuario.senha,
                email: usuario.email,
                telefone: usuario.telefone,
                urlImagem: usuario.foto,
                permissoes:usuario.permissoes
            });
            navigate("/")
        } catch (error) {
            console.log("erro")
        }
    }
   
    return (
        <div className="login-screen__container">
            <form onSubmit={handleSubmit} className="login-screen__form">
                <label>Nome</label>
                <input className="form-input"
                    type="text"
                    placeholder="Nome"
                    name="nome"
                    onChange={handleChange}
                    value={usuario.nome}
                />
                <label>Email</label>
                <input className="form-input"
                    type="text"
                    placeholder="Email"
                    name="email"
                    onChange={handleChange}
                    value={usuario.email}
                />
                <label>Telefone</label>
                <input className="form-input"
                    type="text"
                    placeholder="Telefone"
                    name="telefone"
                    onChange={handleChange}
                    value={usuario.telefone}
                />
                <label>Foto</label>
                <input className="form-input"
                    type="text"
                    placeholder="Foto"
                    name="foto"
                    onChange={handleChange}
                    value={usuario.foto}
                />
                <label>Senha</label>
                <input className="form-input"
                    type="password"
                    placeholder="Senha"
                    name="senha"
                    onChange={handleChange}
                    value={usuario.senha}
                />
                <button className="botao-login">Cadastar</button>
                <label>Já tenho cadastro</label>
                <button className="botao-login" onClick={(() => navigate("/"))}>Logar</button>
            </form>
        </div>
    )
}