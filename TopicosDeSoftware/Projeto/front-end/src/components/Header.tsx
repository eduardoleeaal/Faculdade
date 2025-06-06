import './styles.css';
import {Link} from 'react-router-dom';

function Header() {

    return (
        <header>
            <nav className="navbar">
                <div className="logo">Produtos</div>
                    <ul className="nav-links">
                        <li>
                            <Link to="/pages/produtos/listar">
                                Lista de Produtos
                            </Link>
                        </li>
                        <li>
                            <Link to="/pages/produtos/cadastrar">
                                Cadastrar
                            </Link>
                        </li>
                    </ul>
                </nav>
        </header>
    )
}

export default Header;