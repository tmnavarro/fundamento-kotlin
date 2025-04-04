package alugueis

import java.util.Scanner
import kotlin.random.Random

data class Gamer(val nome: String, var email: String): Recomendavel {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                geraId()
            }
        }
    var id: Int = 0
    var plano: Plano = PlanoAvulso(tipo = "BRONZE")
    val jogos = mutableListOf<Jogo?>()
    val jogosAlugados = mutableListOf<Aluguel?>()
    val jogosRecomendados = mutableListOf<Jogo?>()

    var idInterno: String? = null
        private set

    private val listaNotas = mutableListOf<Int>()
    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    fun recomendarJogo(jogo: Jogo, nota: Int) {
        jogo.recomendar(nota)
        jogosRecomendados.add(jogo)

    }

    init {
        if (nome.isBlank()) {
            throw IllegalArgumentException("Nome não pode ser vazio")
        }
        email = validaEmail()
    }

    constructor(nome: String, email: String, dataNascimento: String?, usuario: String?, id: Int = 0) :
        this(nome, email) {
            this.id = id
            this.dataNascimento = dataNascimento
            this.usuario = usuario
            geraId()
        }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno), lista de jogos: $jogosAlugados" +
                "\n" + "Notas: $media"
    }

    fun geraId() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }


    fun validaEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email inválido")
        }
    }

    fun alugaJogo(jogo: Jogo, periodo: Periodo): Aluguel {
        val aluguel = Aluguel(this, jogo, periodo)
        this.jogosAlugados.add(aluguel)

        return aluguel
    }

    fun jogosDoMes(mes: Int): List<Jogo?> {
        return jogosAlugados.filter { it?.periodo?.dataInicial?.monthValue == mes }.map { it?.jogo }
    }

    companion object {
        fun criarGamer(leitura: Scanner): Gamer {
            println("Digite o nome do gamer: ")
            val nome = leitura.nextLine()
            println("Digite o email do gamer: ")
            val email = leitura.nextLine()
            println("Deseja completar o cadastro? S/N")
            val continuar = leitura.nextLine()

            if (continuar.equals("s", true)) {
                println("Digite a data de nascimento: ")
                val dataNascimento = leitura.nextLine()
                println("Digite o nome de usuário: ")
                val usuario = leitura.nextLine()
                return Gamer(nome, email, dataNascimento, usuario)
            } else {
                return Gamer(nome, email)
            }

        }
    }

}

