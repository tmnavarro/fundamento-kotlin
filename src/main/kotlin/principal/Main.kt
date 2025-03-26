package com.navarrodev.principal

import com.google.gson.Gson
import com.navarrodev.alugueis.InfoJogoApi
import com.navarrodev.alugueis.Jogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner

fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite o código do jogo: ")
    val busca = leitura.nextLine()

    val uri = "https://www.cheapshark.com/api/1.0/games?id=$busca"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(uri))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()



    val gson = Gson()
    val infoJogo = gson.fromJson(json, InfoJogoApi::class.java)
//    try {
//
//        val jogo1 = Jogo(infoJogo.info.title, infoJogo.info.thumb)
//
//        println(jogo1)
//    } catch (ex: NullPointerException) {
//        println("Jogo não encontrado")
//    }

    var jogo1: Jogo? = null

    val resultado = runCatching {
        Jogo(infoJogo.info.title, infoJogo.info.thumb)

        println(jogo1)
    }

    resultado.onFailure {
        println("Jogo não encontrado")
    }

    resultado.onSuccess {
        println("Jogo não encontrado")
    }





}