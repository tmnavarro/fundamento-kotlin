package alugueis

class PlanoAssinatura(tipo: String, val mensalidade: Double, val jogosIncluidos: Int): Plano(tipo) {

    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogoMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size + 1

        return if (totalJogoMes <= jogosIncluidos) {
            0.0
        }else {
            super.obterValor(aluguel)
        }

    }
}