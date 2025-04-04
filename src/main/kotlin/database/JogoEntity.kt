package database

import javax.persistence.*

@Entity
@Table(name = "jogos")
class JogoEntity (
    val titulo: String= "Titulo vazio",
    val capa: String = "Capa vazia",
    val descricao: String = "Descricao vazia",
    val preco: Double = 0.0,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0) {


}