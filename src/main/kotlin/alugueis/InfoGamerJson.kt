package alugueis

data class InfoGamerJson(val nome: String, val email: String, val dataNascimento: String, val usuario: String) {
    override fun toString(): String {
        return "InfoGamerJson(nome='$nome', email='$email', dataNascimento='$dataNascimento', usuario='$usuario')"
    }
}