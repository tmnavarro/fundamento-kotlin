package com.navarrodev.com.navarrodev.alugueis

data class InfoJogoApi(val info: InfoApiShark) {

    override fun toString(): String {
        return info.toString()
    }
}