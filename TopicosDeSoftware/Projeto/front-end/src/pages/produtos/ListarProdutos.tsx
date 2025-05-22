import './listar-produto-modulo.css';
import { useEffect, useState } from 'react';
import axios from 'axios';
import { Produto } from '../../models/Produto';


export default function ListarProdutos() {
    return (
        <div>
        const [produtos, setProdutos] = useState<Produto[]>([]);

        useEffect(() => {
            carregarProdutos();
        }, []);

        function carregarProdutos(){
            axios.get("http://localhost:5291/api/produtos")
            .then(response => {
                console.table(response.data);
                setProdutos(response.data);
            }).catch( error => {
                console.log(error);
            });
        }
        
            <h1>Lista de Produtos</h1>
        

        <table>
            <thead>
            <tr>
                <td>#</td>
                <td>Nome</td>
                <td>Categoria</td>
                <td>Criado em</td>
                <td></td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            {produtos.map( (produto) => (
                <tr key={produto.id}>
                <td>{produto.id}</td>
                <td>{produto.nome}</td>
                <td>{produto.categoria.nome}</td>
                <td>{new Date(produto.criadoEm).toLocaleDateString('pt-BR')}</td>
                <td>
                    <button>Apagar</button>
                </td>
                <td>
                    <button>Alterar</button>
                </td>
                </tr>
            </tbody>
        </table>
            </div>
        ))}
    )
};