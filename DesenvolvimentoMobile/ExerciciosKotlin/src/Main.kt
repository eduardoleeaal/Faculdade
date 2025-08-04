fun main() {
    // ex001()
    // ex003()
    // ex004()
    // ex005()
    // ex006()
    ex007()
}

fun ex001() {
    println("Informe a primeira nota: ")
    val nota1 = readln().toFloat()
    println("Informe a segunda nota: ")
    val nota2 = readln().toFloat()
    println("Informe a terceira nota: ")
    val nota3 = readln().toFloat()

    val media = (nota1 + nota2 + nota3) / 3

    if (media >= 7.0) {
        println("Aprovado com média: %.2f".format(media))
    } else if (media >= 5.0) {
        println("Recuperação com média: %.2f".format(media))
    } else {
        println("Reprovado com média: %.2f".format(media))
    }
}

fun ex003() {
    for (i in 10 downTo 1) {
        println(i)
    }
}

fun ex004() {
    var soma = 0;
    for (cont in 1..100){
        soma += cont;
    }
    println("Soma: $soma")
}

fun ex005() {
    println("Digite um número para ver a tabuada: ")
    val escolha = readln().toInt();

    for (i in 1 .. 10){
        println("$escolha x $i = ${escolha * i}")
    }
}

fun ex006() {
    println("Informe o valor que deseja calcular a fatorial: ")
    val valor = readln().toInt();
    var fatorial: Long = 1L;

    for (cont in 1 .. valor) {
        fatorial *= cont
    }

    println("$valor! = $fatorial")
}

fun ex007(){
    println("Escreva algo: ")
    val frase = readln().lowercase();
    var contVogais = 0;
    for (letra in frase){
        if (letra in "aeiou"){
            contVogais++;
        }
    }
    println("Quantidade de vogais: $contVogais");
}