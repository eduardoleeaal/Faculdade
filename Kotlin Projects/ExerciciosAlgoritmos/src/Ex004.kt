fun main(){
    print("Digite a primeira nota: ")
    val nota1 = readlnOrNull()?.toDouble()?: 0.0
    print("Digite a segunda nota: ")
    val nota2 = readlnOrNull()?.toDouble()?: 0.0
    print("Digite a terceira nota: ")
    val nota3 = readlnOrNull()?.toDouble()?: 0.0

    val media = (nota1 * 2 + nota2 * 3 + nota3 * 5) / 10

    println("Média: %.2f".format(media))
}