import { useEffect, useState } from 'react';
import ListarProdutos from './pages/produtos/ListarProdutos';
import Header from './components/Header'; // Import the Header component
import axios from 'axios';
import { Produto } from './models/Produto';
// 1 -> Um componente SEMPRE deve começar com a primeira letra maiúscula
// 2 -> Todo componente DEVE ser uma função do JS
// 3 -> Todo deve retornar apenas um elemento HTML

function App() {
  

  return (
    <div>

      <Header />
      <ListarProdutos />
    </div>
  );
}

// 4 -> OBRIGATORIAMENTE DEVE SER EXPORTADO
export default App;
