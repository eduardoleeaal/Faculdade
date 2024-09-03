#include <stdio.h>

int main(){
    float real, dolar, cotacao;

    printf("Digite a quantidade de reais: R$");
    scanf("%f", real);

    printf("Digite a cotação atual do dolar: ");
    scanf("%f", cotacao);

    dolar = real * cotacao;

    printf("R$%.2f = $%.2f", real, dolar);

    return 0;
}