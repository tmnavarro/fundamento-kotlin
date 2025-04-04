package database

import alugueis.Jogo
import javax.persistence.EntityManager


class JogoDAO(manager : EntityManager): DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {

    override fun toEntity(objeto: Jogo): JogoEntity {
        return JogoEntity(
            id = objeto.id,
            titulo = objeto.titulo,
            capa = objeto.capa,
            descricao = objeto.descricao,
            preco = objeto.preco
        )
    }

    override fun toModel(entity: JogoEntity): Jogo {
        return Jogo(
            id = entity.id,
            titulo = entity.titulo,
            capa = entity.capa,
            descricao = entity.descricao,
            preco = entity.preco
        )
    }



//    fun getJogos(): List<Jogo> {
//        val listaJogos = mutableListOf<Jogo>()
//        val conecao = obterConexao()
//
//        if (conecao != null) {
//            try {
//                val statement = conecao.createStatement()
//                val resultSet = statement.executeQuery("SELECT * FROM jogos")
//                while (resultSet.next()) {
//                    val id = resultSet.getInt("id")
//                    val titulo = resultSet.getString("titulo")
//                    val capa = resultSet.getString("capa")
//                    val descricao = resultSet.getString("descricao")
//                    val preco = resultSet.getDouble("preco")
//
//                    val jogo = Jogo(titulo, capa, descricao, preco, id)
//                    listaJogos.add(jogo)
//                }
//                statement.close()
//            } finally {
//                conecao.close()
//            }
//        }
//        return listaJogos
//    }
//
//    fun adicionaJogo(jogo: Jogo) {
//        val conecao = obterConexao()
//        val insert = "INSERT INTO jogos (titulo, capa, descricao, preco) VALUES (?, ?, ?, ?)"
//
//        if (conecao != null) {
//            try {
//                val preparedStatement = conecao.prepareStatement(insert)
//                preparedStatement.setString(1, jogo.titulo)
//                preparedStatement.setString(2, jogo.capa)
//                preparedStatement.setString(3, jogo.descricao)
//                preparedStatement.setDouble(4, jogo.preco)
//
//                preparedStatement.executeUpdate()
//                preparedStatement.close()
//            } finally {
//                conecao.close()
//            }
//        }
//
//    }
}