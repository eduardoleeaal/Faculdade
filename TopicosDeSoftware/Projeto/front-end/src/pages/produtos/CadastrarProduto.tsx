import axios from "axios";
import { useEffect, useState } from "react";
import { Categoria } from "../../models/Categoria";
import { Produto } from "../../models/Produto";

export default function CadastrarProduto() {
    const [nome, setNome] = useState("");
    const [preco, setPreco] = useState<number>(0);
    const [descricao, setDescricao] = useState("");
    const [quantidade, setQuantidade] = useState<number>(0);
    const [categoriaId, setCategoriaId] = useState<any>(null);
    const [categorias, setCategorias] = useState<Categoria[]>([]);

    useEffect(() => {
        const id = "bec44381-28db-46f0-b26f-f2ded8cc0f99";
        carregarCategorias();
        buscarProdutoPorId(id);
    }, []);

    function buscarProdutoPorId(id: string) {
        axios.get(`http://localhost:5291/api/produtos/${id}`)
            .then(response => {
                var produto = response.data;
                setNome(produto.nome);
                setPreco(produto.preco);
                setDescricao(produto.descricao);
                setQuantidade(produto.quantidade);
                setCategoriaId(produto.categoriaId);
            })
            .catch(error => {
                alert("Erro ao carregar as categorias");
            });
    }

    function carregarCategorias() {
        axios.get("http://localhost:5291/api/categorias")
            .then(response => {
                setCategorias(response.data);
                setCategoriaId(response.data[0]?.id);
            })
            .catch(error => {
                alert("Erro ao carregar as categorias");
            });
    }

    function salvar(e: any) {
        e.preventDefault();
        const p = {
            nome: nome,
            preco: Number(preco),
            descricao: descricao,
            quantidade: Number(quantidade),
            categoriaId: categoriaId
        }
        console.log(p);
        cadastrar(p);
    }

    function cadastrar(produto: any) {
        axios.post("http://localhost:5291/api/produtos", produto)
            .then(response => {
                console.log(response);
                alert("Produto Cadastrado com Sucesso!");
            })
            .catch(error => {
                alert("Ocorreu um erro ao cadastrar o produto");
            })
    }

    return (
        <div>
            <h1>Cadastrar Produtos</h1>
            <form onSubmit={salvar}>
                <div>
                    <label htmlFor="nome">Nome</label> <br />
                    <input
                        onChange={(e: any) => setNome(e.target.value)}
                        value={nome}
                        type="text" id="nome"
                        placeholder="Digite o nome do produto"
                        required />
                </div>

                <div>
                    <label htmlFor="descricao">Descricao</label> <br />
                    <textarea
                        onChange={(e: any) => setDescricao(e.target.value)}
                        value={descricao}
                        id="descricao"
                        placeholder="Digite a descrição do produto"
                        required />
                </div>

                <div>
                    <label htmlFor="quantidade">Quantidade</label> <br />
                    <input
                        onChange={(e: any) => setQuantidade(e.target.value)}
                        value={quantidade}
                        type="number"
                        step="1"
                        min="0"
                        id="quantidade"
                        placeholder="Digite a quantidade de produtos"
                        required />
                </div>

                <div>
                    <label htmlFor="preco">Preço</label> <br />
                    <input
                        onChange={(e: any) => setPreco(e.target.value)}
                        value={preco}
                        type="number"
                        step="0.01"
                        min="0"
                        id="preco"
                        placeholder="Digite a preço de produtos"
                        required />
                </div>
                <div>
                    <label htmlFor="preco">Categoria</label> <br />
                    <select id="categoria"
                        onChange={(e: any) => setCategoriaId(Number(e.target.value))}
                        value={categoriaId} >
                        {categorias.map((item) => (
                            <option key={item.id} value={item.id}>
                                {item.nome}
                            </option>
                        ))}
                    </select>
                </div>

                <button type="submit">
                    Salvar
                </button>

            </form>
        </div>
    );

}

