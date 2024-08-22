fun main(){
    print("Digite horas: ")
    val horas = readlnOrNull()?.toInt()?: 0
    print("Digite minutos: ")
    val minutos = readlnOrNull()?.toInt()?: 0
    print("Digite segundos: ")
    val segundos = readlnOrNull()?.toInt()?: 0

    val total = horas * 3600 + minutos * 60 + segundos

    println("${horas}h:${minutos}m:${segundos}s = $total Segundos")
}