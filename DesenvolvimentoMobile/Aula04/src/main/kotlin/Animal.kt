open abstract class Animal(var nome: String) {
    open fun falar() {
        println("$nome fez um som...")
    }
}

class Cachorro(nome: String, var raca: String) : Animal(nome) {
    override fun falar(){
        println("O $nome da raça $raca Latiu")
    }
}

class Gato(nome: String, var cor: String) : Animal(nome) {
    override fun falar() {
        println("O $nome da cor $cor Miou!")
    }
}