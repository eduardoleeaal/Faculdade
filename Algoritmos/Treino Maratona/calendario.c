/*
Data com mês por extenso.
Construa uma função que receba uma data no formato DD/MM/AAAA e devolva uma string no formato D de mesPorExtenso de AAAA.
Opcionalmente, valide a data e retorne NULL caso a data seja inválida.
*/

#include <stdio.h>
#include <string.h>

int main()
{

    int dia, mes, ano;
    printf("Digite a data no formato DD/MM/AAAA: ");
    scanf("%d/%d/%d", &dia, &mes, &ano);

    return 0;
}

char dataExtenso(int dia, int mes, int ano)
{
    char mesExtenso[15];

    switch (mes)
    {
    case 1:
        strcpy(mesExtenso, "Janeiro");
        break;
    case 2:
        strcpy(mesExtenso, "Fevereiro");
        break;
    case 3:
        strcpy(mesExtenso, "Marco");
        break;
    case 4:
        strcpy(mesExtenso, "Abril");
        break;
    case 5:
        strcpy(mesExtenso, "Maio");
        break;
    case 6:
        strcpy(mesExtenso, "Junho");
        break;
    case 7:
        strcpy(mesExtenso, "Julho");
        break;
    case 8:
        strcpy(mesExtenso, "Agosto");
        break;
    case 9:
        strcpy(mesExtenso, "Setembro");
        break;
    case 10:
        strcpy(mesExtenso, "Outubro");
        break;
    case 11:
        strcpy(mesExtenso, "Novembro");
        break;
    case 12:
        strcpy(mesExtenso, "Dezembro");
        break;
    default:
        printf("Mês incorreto");
        break;
    }

    return 
}