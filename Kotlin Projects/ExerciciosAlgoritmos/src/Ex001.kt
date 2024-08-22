fun main(){
    println("Digite a base do Triangulo: ")
    val base = readlnOrNull()?.toDouble()?: 0.0
    println("Digite a altura do Triangulo: ")
    val altura = readlnOrNull()?.toDouble()?: 0.0

    val area = (base * altura) / 2

    println("A area do Triangulo é: $area")

}