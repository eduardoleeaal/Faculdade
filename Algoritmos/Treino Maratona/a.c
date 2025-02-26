#include <stdio.h>

int main()
{

    int matriz[2][3], i, j;
    int maior, menor;
    for (i = 0; i < 2; i++)
    {
        for (j = 0; j < 3; j++)
        {
            printf("Digite seu numero %d %d: ", i, j);
            scanf("%d", &matriz[i][j]);
        }
    }

    maior = matriz[0][0];
    menor = matriz[0][0];

    for (i = 0; i < 2; i++)
    {
        for (j = 0; j < 3; j++)
        {
            if (matriz[i][j] < menor)
            {
                menor = matriz[i][j];
            }
            else if (matriz[i][j] > maior)
            {
                maior = matriz[i][j];
            }
        }
    }
    printf("Maior: %d", maior);

    return 0;
}