
//JOGO SORTEIO

const numeroSorteado = document.querySelector('#numeroSorteado');

const numeroEscolhidoInput = document.querySelector('#numeroEscolhido')

const maior = document.querySelector('#maior');
const menor = document.querySelector('#menor');

const sorteio = document.querySelector('#sorteio');

const mostrarCreditos = document.querySelector('#mostrarCreditos');

let creditos = 100;

function numAleatorio(min, max){
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min) + min);
}

function escolheMaior(){
    numeroSorteado.textContent = "Sorteando...";
    setTimeout(() => {
    let numeroAleatorio = (numAleatorio(0, 1001));
    numeroSorteado.textContent = numeroAleatorio; //    Sorteia e exibe um número aleatório entre 0 e 1001

    numeroEscolhido = parseInt(numeroEscolhidoInput.value);

    if(parseInt(numeroEscolhido) > parseInt(numeroAleatorio)){
        if(parseInt(numeroEscolhido) > 1000 || parseInt (numeroEscolhido) < 0){
            alert("Número Inválido, o valor inserido deve estar entre 0 e 1000 :)")
        }
        else if(creditos <=0){
            alert("Saldo Insuficiente");
        }
        else{
        sorteio.style.backgroundColor = 'green';
        creditos += 2;
        mostrarCreditos.textContent = creditos;
        }
    }
    else if(creditos <=0){
        alert("Saldo Insuficiente");
    }
    else{
        sorteio.style.backgroundColor = 'red';
        creditos -= 2;
        mostrarCreditos.textContent = creditos;
    }

}, 800);
}

function escolheMenor(){
        numeroSorteado.textContent = "Sorteando...";
        setTimeout(() => {
        let numeroAleatorio = (numAleatorio(0, 1001));
        numeroSorteado.textContent = numeroAleatorio; //    Sorteia e exibe um número aleatório entre 0 e 1001
    
        numeroEscolhido = parseInt(numeroEscolhidoInput.value);
    
        if(parseInt(numeroEscolhido) < parseInt(numeroAleatorio)){
            if(parseInt(numeroEscolhido) > 1000 || parseInt (numeroEscolhido) < 0){
                alert("Número Inválido, o valor inserido deve estar entre 0 e 1000 :)")
            }
            else if(creditos <=0){
                alert("Saldo Insuficiente");
            }
            else{
            sorteio.style.backgroundColor = 'green';
            creditos += 2;
            mostrarCreditos.textContent = creditos;
            }
        }
        else if(creditos <=0){
            alert("Saldo Insuficiente");
        }
        else{
            sorteio.style.backgroundColor = 'red';
            creditos -= 2;
            mostrarCreditos.textContent = creditos;
        }
    }, 800);
    }

maior.addEventListener("click", escolheMaior);
menor.addEventListener("click", escolheMenor);