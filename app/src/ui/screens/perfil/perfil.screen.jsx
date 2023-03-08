import "./index.css"
import { useAuth} from "../../../api"
import { useGlobalUser } from "../../../contexts/user/user.contexts"
import { useNavigate } from "react-router-dom";



export function PerfilScreen() {
    const [user] = useGlobalUser()
    const auth = useAuth()
    const navigate = useNavigate()
    
    async function handleClick(event) {
        event.preventDefault();
        try {
            const user = await auth.logout()
            navigate("/")
        } catch (error) {
            console.log("erro")
        }
    }

    return (
        <main className="container-perfil-screen">
            <div className="perfil-usuario">
                <div>
                    <img className="imagem-perfil" src={user?.urlImagem} alt="imagem perfil" />
                    <div className="dados-usuario">
                        <p>Nome: {user?.nome}</p>
                        <p>Telefone: {user?.telefone}</p>
                        <p>Email de contato: {user?.email} </p>
                    </div>
                </div>
                <div className="boteos-perfil">
                    <button className="botao-logout" onClick={handleClick}> Sair </button>
                </div>
            </div>
        </main>
    )
}