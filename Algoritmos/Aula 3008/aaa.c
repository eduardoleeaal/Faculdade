#include <stdio.h>
#include <ctype.h>

int main()
{
    float altura, peso_ideal = 0;
    char genero;

    printf("Informe altura: ");
    scanf("%f", &altura);

    fflush(stdin);

    printf("Informe o genero: "); 
    scanf("%c", &genero);

    if (toupper(genero) == 'M') {
        peso_ideal = 72.7 * altura - 58;
    }
    else if (toupper(genero) == 'F') {
        peso_ideal = 62.1 * altura - 44.7;
    }
    else {
        printf("Genero Incorreto");
        return 0;
    }
    
    printf("Peso Ideal: %.1f", peso_ideal);

    return 0;
}