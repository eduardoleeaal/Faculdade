const janelaModal = document.querySelector('.modal');
const btn = document.querySelector('#btn');
const estiloAtual = janelaModal.style.display

function ativarModal(){
    janelaModal.style.display = 'flex';
}

function desativarModal(){

    const estiloAtual = janelaModal.style.display

    if(estiloAtual == 'flex'){
        janelaModal.style.display = 'none'
    }
}

btn.addEventListener("click", ativarModal);
janelaModal.addEventListener("click", desativarModal);
