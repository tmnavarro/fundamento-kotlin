package database

import javax.persistence.*

@Entity
@Table(name = "planos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TipoPlano", discriminatorType = DiscriminatorType.STRING)
open class PlanoEntity(
    open val tipo: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int = 0)

@Entity
@DiscriminatorValue("Avulso")
class PlanoAvulsoEntity(tipo: String = "Plano Avulso", id: Int = 0): PlanoEntity(tipo, id)

@Entity
@DiscriminatorValue("Assinatura")
class PlanoAssinaturaEntity(
    tipo: String = "Plano Assinatura",
    val mensalidade: Double = 0.0,
    val jogosIncluidos: Int = 0,
    val valorDesconto: Double = 0.0,
    id: Int = 0): PlanoEntity(tipo, id)