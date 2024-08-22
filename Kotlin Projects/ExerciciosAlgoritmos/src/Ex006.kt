fun main(){
    print("Digite em R$: R$")
    val reais = readlnOrNull()?.toDouble()?: 0.0
    print("Digite a cotação atual: $")
    val cotacao = readlnOrNull()?.toDouble()?: 0.0

    val dolar = reais / cotacao

    println("R$%.2f = $%.2f".format(reais, dolar))
}