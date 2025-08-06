fun main() {
    val p1 = Pessoa("Eduardo", 21)
    p1.falar("Olá")
    val v1 = Carro("VW", "MKX-1309")
    println("Carro da marca: ${v1.marca}")
    println("Placa: ${v1.placa}")

    val cachorro = Cachorro("Toby", "Lhasa")
    cachorro.falar()
    val gato = Gato("Pepito", "Preto")
    gato.falar()

    val user1 = Usuario(1, "leal", "coxa12345")
    val user2 = Usuario(2, "pericles1999", "qwert159753")
    val user3 = user1.copy()
    println("Usuários cadastrados: ")
    println(user1)
    println(user2)
    println(user3)
}