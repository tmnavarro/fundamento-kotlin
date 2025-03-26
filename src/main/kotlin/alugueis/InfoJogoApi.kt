package alugueis

data class InfoJogoApi(val info: InfoApiShark) {

    override fun toString(): String {
        return info.toString()
    }
}