package alugueis

class Jogo(val titulo: String,val capa: String) {

    var descricao:String? = null
    var preco = 0.0

    constructor(titulo: String, capa: String, descricao: String, preco: Double) :
        this(titulo, capa) {
            this.preco = preco
            this.descricao = descricao
        }

    override fun toString(): String {
        return "Jogo(titulo='$titulo', capa='$capa', descricao=$descricao, preco=$preco)"
    }


}