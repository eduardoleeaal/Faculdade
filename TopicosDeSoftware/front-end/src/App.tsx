import { useState } from 'react';
import Button from './components/Button';
import Header from './components/Header';

// 1 -> Um componente SEMPRE deve começar com a primeira letra maiúscula
// 2 -> Todo componente DEVE ser uma função do JS
// 3 -> Todo deve retornar apenas um elemento HTML

function App() {

  const [click, setClick] = useState(0);

  function handleClick() {
      setClick(click + 1);
  }

  return (
    <div>
      <Header />
      <h1>Projeto base em React com TypeScript</h1>
      <Button texto="Botão I" valor={click} evento={handleClick}/>
      <Button texto="Botão II" valor={click} evento={handleClick}/>
    </div>
  );
}

// 4 -> OBRIGATORIAMENTE DEVE SER EXPORTADO
export default App;
