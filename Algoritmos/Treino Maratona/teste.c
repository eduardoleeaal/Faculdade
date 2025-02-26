#include <stdio.h>

int main() {
    char nome[20];

    printf("Digite seu nome: ");
    gets(nome);  // Lê uma linha de texto do teclado
    printf("Seu nome é: %s\n", nome);

    return 0;
}
