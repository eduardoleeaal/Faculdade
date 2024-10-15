#include <stdio.h>

int main(){

    int senha = 2009, count = 0;
    
    do{
        printf("Digite a senha: ");
        scanf("%d", &senha);
        count++;
    }while(senha != 2009);

    printf("ACESSO CONCEDIDO!\n");
    printf("Tentativas: %d", count);

    return 0;
}