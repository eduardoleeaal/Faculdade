class Produto (var nome: String, var preco: Double, var quantiade: Int) {
    init {
        if (quantiade < 0) {
            this.quantiade = 0
        }
        require(preco >=0f) { "Preço deve ser maior que zero!" }
    }
}