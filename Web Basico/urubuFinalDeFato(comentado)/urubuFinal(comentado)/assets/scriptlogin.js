login = document.querySelector("#login");
senha = document.querySelector("#senha");
btn = document.querySelector("#btn");

function validarLogin() {
    if (login.value === "root" && senha.value === "12345") {
        console.log("Acesso Autorizado");
        setTimeout(() => {
            window.location.href = './index.html'; //   Redireciona para a página principal(index.html)
        }, 1500);
    } else {
        alert("Login ou senha inválidos!");
    }
}

btn.addEventListener("click", function(event) {
    event.preventDefault(); //  Impede o comportamento padrão do botão (envio do formulário/f5 na página)
    validarLogin();
});

