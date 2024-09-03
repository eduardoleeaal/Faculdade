#include <stdio.h>

int main(){
    float nota1, nota2, nota3, media;
    
    printf("Digite a nota 1: ");
    scanf("%f", &nota1);
    printf("Digite a nota 2: ");
    scanf("%f", &nota2);
    printf("Digite a nota 3: ");
    scanf("%f", &nota3);

    media = (nota1 * 2 + nota2 * 3 + nota3 * 5) / 10;

    printf("Media ponderada: %.2f", media);

    return 0;
}