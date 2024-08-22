#include <stdio.h>

int main(){
    float base, altura, area;
    
    printf("Digite a base: ");
    scanf("%f", &base);

    printf("Digite a altura: ");
    scanf("%f", &altura);

    area = base * altura / 2;

    printf("Area: %.1f x %.1f / 2 = %.1f", base, altura, area);

    return 0;
}