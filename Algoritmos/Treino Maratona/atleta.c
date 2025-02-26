#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

    float notas[7];
    char nome[50];
    float soma = 0;
    float maxNota;
    float minNota;

    printf("Digite seu nome: ");
    gets(nome);
    
    fflush(stdin);
    for (int i = 0; i < 7; i++)
    {
        printf("Nota: ");
        scanf("%f", &notas[i]);
        if (i == 0)
        {
            maxNota = notas[i];
            minNota = notas[i];
        } else {
            if (notas[i] > maxNota)
            {
                maxNota = notas[i];
            }
            if (notas[i] < minNota)
            {
                minNota = notas[i];
            }
        }
        soma += notas[i];
    }

    printf("\nResultado Final: ");
    printf("Atleta: %s", nome);
    printf("Melhor nota: %.1f", maxNota);
    printf("Pior nota: %.1f", minNota);
    printf("Media: %.1f", soma/7);

    return 0;
}