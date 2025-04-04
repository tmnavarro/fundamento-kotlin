package alugueis

import com.google.gson.annotations.Expose


class Jogo(
    @Expose
    val titulo: String,
    @Expose
    val capa: String
) : Recomendavel {
    var id: Int = 0

    var descricao: String = ""
    var preco = 0.0

    private val listaNotas = mutableListOf<Int>()
    override val media: Double
        get() = listaNotas.average()

    constructor(titulo: String, capa: String, descricao: String, preco: Double, id: Int = 0) :
            this(titulo, capa) {
        this.id = id;
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "Jogo(titulo='$titulo', capa='$capa', descricao=$descricao, preco=$preco), notas: $media"
    }

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }


}