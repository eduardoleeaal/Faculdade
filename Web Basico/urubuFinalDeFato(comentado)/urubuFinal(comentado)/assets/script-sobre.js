let indiceAtual = 0; // Índice da imagem atual
const imagens = document.querySelectorAll('#slide img'); // Seleciona todas as imagens

        // Função para mudar o slide (1 = próximo, -1 = anterior)
        function mudarSlide(direcao) {
            imagens[indiceAtual].classList.remove('active'); // Esconder imagem atual
            indiceAtual = (indiceAtual + direcao + imagens.length) % imagens.length; // Ajustar o índice
            imagens[indiceAtual].classList.add('active'); // Mostrar a nova imagem
        }

        // Slide automático a cada 3 segundos
        setInterval(() => mudarSlide(1), 6000); // Muda automaticamente para o próximo slide a cada 3 segundos
        