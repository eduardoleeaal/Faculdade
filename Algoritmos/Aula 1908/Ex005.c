#include <stdio.h>
#include <locale.h>

int main(){
    setlocale(LC_ALL, "Portuguese");
    float celsius, fahrenheit;

    printf("Digite um valor em °C: ");
    scanf("%f", &celsius);

    fahrenheit = (celsius * 9/5) + 32;

    printf("%.1f°C = %.1f°F", celsius, fahrenheit);

    return 0;
}