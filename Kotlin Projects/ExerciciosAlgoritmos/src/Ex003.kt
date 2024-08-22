fun main(){
    print("Digite um numero: ")
    val num = readlnOrNull()?.toInt()?: 0

    println("Antecessor: ${num - 1}, Numero: ${num}, Sucessor: ${num + 1}")

}