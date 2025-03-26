package alugueis

import kotlin.random.Random

data class Gamer(val nome: String, val email: String) {
    var dataNascimento:String? = null
    var usuario:String? = null
        set(value) {
            field = value
            if(idInterno.isNullOrBlank()) {
                geraId()
            }
        }



    var idInterno:String? = null
        private set

    constructor(nome: String, email: String, dataNasimento: String, usuario:String) :
        this(nome, email) {
            this.dataNascimento = dataNasimento
            this.usuario = usuario
            geraId()
        }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun geraId()  {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }


}

