fun main(){
    print("Digite a temperatura em °C: ")
    val celsius = readlnOrNull()?.toDouble()?: 0.0

    val fahrenheit = celsius * 9/5 + 32

    println("Temperatura convertida: %.1f °F".format(fahrenheit))
}