fun main() {
    val msg = mensagem("eduardo")
    println(msg)
    // val valor = readln().toInt()
    // if (parOuImpar(valor)){
    //     println("É Par");
    // } else {
    //     println("É Impar")
    // }

    criarPote()
    criarPote(tipo = "Baunilha")
    criarPote(quantidade = 15)

    exemploListImutavel()
    exemploListMutavel()
    exemploLambda01()
    exemploLambda02()

    exLambda01()
    exLambda02()
}

fun mensagem(nome: String) : String {
    return "Olá, $nome"
}

fun parOuImpar(valor : Int): Boolean {
    return valor % 2 == 0
}

fun verificarParOuImpar(valor : Int) : String {
    return if (valor % 2 == 0) "É par" else "É impar"
}

fun criarPote(tipo: String = "Chocolate", quantidade : Int = 10) {
    println("$quantidade Potes de $tipo")
}

fun exemploListImutavel() {
    val nomes : List<String> = listOf("Eduardo", "Carlos", "Pedro", "Bruno")
    println(nomes)

    for (nome in nomes){
        println(nome)
    }
}

fun exemploListMutavel() {
    val numeros = mutableListOf(1, 5, 6, 7, 3)
    numeros.add(1, 2)
    numeros.add(8)

    println(numeros)
    numeros.forEach { println(it) }
}

fun exemploLambda01() {
    val dobro : (Int) -> Int = { x -> x * 2}
    println("O dobro de 5 é ${dobro(5)}")
}

fun exemploLambda02() {
    val quadrado : (Int) -> Int = { it * it }
    println("O Quadrado de 6 é ${quadrado(6)}")
}

fun exLambda01() {
    val multiplica : (Double, Double) -> Double = { a, b -> a * b }
    println(multiplica(2.5, 4.0))
}

fun exLambda02() {
    val cumprimenta : (String) -> String = {nome -> "Olá, $nome"}
    println(cumprimenta("Eduardo"))
}