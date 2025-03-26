package servicos

import alugueis.InfoJogoApi
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsumoApi {

    fun buscaJogo(id: String): InfoJogoApi {
        val uri = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .build()
        val response = client
            .send(request, BodyHandlers.ofString())

        val json = response.body()



        val gson = Gson()
        val infoJogo = gson.fromJson(json, InfoJogoApi::class.java)

        return infoJogo
    }
}