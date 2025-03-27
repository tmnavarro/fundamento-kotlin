package servicos

import alugueis.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import extensions.criaGamer
import extensions.criaJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsumoApi {

    fun requestData(uri: String): String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .build()
        val response = client
            .send(request, BodyHandlers.ofString())

        return response.body()
    }

    fun buscaJogo(id: String): InfoJogoApi {
        val uri = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val json = requestData(uri)


        val gson = Gson()
        val infoJogo = gson.fromJson(json, InfoJogoApi::class.java)

        return infoJogo
    }

    fun buscaGamers(): List<Gamer> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = requestData(endereco)

        val gson = Gson()
        val meuGamerTipo = object : TypeToken<List<InfoGamerJson>>() {}.type
        val listaGamer:List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerConvertida = listaGamer.map { infoGamerJson -> infoGamerJson.criaGamer() }

        return listaGamerConvertida

    }

    fun buscaJogos(): List<Jogo> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = requestData(endereco)

        val gson = Gson()
        val listaJogoTipo = object : TypeToken<List<InfoJogoJson>>() {}.type
        val listaJogos:List<InfoJogoJson> = gson.fromJson(json, listaJogoTipo)

        val listaGamerConvertida = listaJogos.map { listaJogosJson -> listaJogosJson.criaJogo() }

        return listaGamerConvertida

    }
}