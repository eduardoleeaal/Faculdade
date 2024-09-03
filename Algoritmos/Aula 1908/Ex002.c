#include <stdio.h>

int main(){
    int horas, minutos, segundos, total;

    printf("Digite a quantidade de horas: ");
    scanf("%d", &horas);
    printf("Digite a quantidade de minutos: ");
    scanf("%d", &minutos);
    printf("Digite a quantidade de segundos: ");
    scanf("%d", &segundos);

    total = (horas * 360) + (minutos * 60) + segundos;

    printf("Total de segundos: %d", total);

    return 0;
}