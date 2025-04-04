package alugueis

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
    val valorDesconto: Double,
    id: Int = 0
    ) :
    Plano(tipo, id) {

    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogoMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size + 1

        return if (totalJogoMes <= jogosIncluidos) {
            0.0
        } else {
            return if (aluguel.gamer.media > 0) {
                super.obterValor(aluguel) - (super.obterValor(aluguel) * valorDesconto)
            } else {
                super.obterValor(aluguel)
            }
        }

    }
}