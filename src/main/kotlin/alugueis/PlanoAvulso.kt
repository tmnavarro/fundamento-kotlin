package alugueis

class PlanoAvulso (
   tipo: String,
   id: Int = 0
): Plano(tipo, id) {

   override fun obterValor(aluguel: Aluguel): Double {
      val valorOriginal = super.obterValor(aluguel)
      return if(aluguel.gamer.media > 8.0) {
         valorOriginal * 0.9
      } else {
         valorOriginal
      }
   }

}
