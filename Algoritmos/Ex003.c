#include <stdio.h>

int main(){
    int n;

    printf("Digite um numero: ");
    scanf("%d", &n);

    printf("Antecessor: %d | Sucessor: %d", n - 1, n + 1);

    return 0;
}