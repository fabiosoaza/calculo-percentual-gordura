package com.example.calculo.percentual.gordura.calculadora

import java.lang.IllegalArgumentException
import java.math.BigDecimal
import com.example.calculo.percentual.gordura.utils.BigDecimalUtils.Companion.valorMenor
import com.example.calculo.percentual.gordura.utils.BigDecimalUtils.Companion.valorMaiorOuIgual

class ClassificadoraPercentualGordura {

    fun classificar(sexo:Sexo, percentualGordura: BigDecimal): ClassificacaoPercentualGordura {
        return if (sexo == Sexo.MASCULINO) classificarPercentualMasculino(percentualGordura)
        else classificarPercentualFeminino(percentualGordura)
    }

    private fun classificarPercentualMasculino(percentualGordura: BigDecimal): ClassificacaoPercentualGordura {
        return when {
            valorMenor(percentualGordura, toBigDecimal(5)) -> ClassificacaoPercentualGordura.MAGRO
            valorMaiorOuIgual(percentualGordura, toBigDecimal(5)) && valorMenor(
                percentualGordura,
                toBigDecimal(9)
            ) -> ClassificacaoPercentualGordura.ABAIXO_MEDIA
            valorMaiorOuIgual(percentualGordura, toBigDecimal(9)) && valorMenor(
                percentualGordura,
                toBigDecimal(17)
            ) -> ClassificacaoPercentualGordura.MEDIA
            valorMaiorOuIgual(percentualGordura, toBigDecimal(17)) && valorMenor(
                percentualGordura,
                toBigDecimal(25)
            ) -> ClassificacaoPercentualGordura.ACIMA_MEDIA
            valorMaiorOuIgual(
                percentualGordura,
                toBigDecimal(25)
            ) -> ClassificacaoPercentualGordura.OBESO
            else -> throw IllegalArgumentException()
        }
    }

    private fun classificarPercentualFeminino(percentualGordura: BigDecimal): ClassificacaoPercentualGordura {
        return when {
            valorMenor(percentualGordura, toBigDecimal(9)) -> ClassificacaoPercentualGordura.MAGRO
            valorMaiorOuIgual(percentualGordura, toBigDecimal(9)) && valorMenor(
                percentualGordura,
                toBigDecimal(15)
            ) -> ClassificacaoPercentualGordura.ABAIXO_MEDIA
            valorMaiorOuIgual(percentualGordura, toBigDecimal(15)) && valorMenor(
                percentualGordura,
                toBigDecimal(23)
            ) -> ClassificacaoPercentualGordura.MEDIA
            valorMaiorOuIgual(percentualGordura, toBigDecimal(23)) && valorMenor(
                percentualGordura,
                toBigDecimal(30)
            ) -> ClassificacaoPercentualGordura.ACIMA_MEDIA
            valorMaiorOuIgual(
                percentualGordura,
                toBigDecimal(30)
            ) -> ClassificacaoPercentualGordura.OBESO
            else -> throw IllegalArgumentException()
        }
    }

    private fun toBigDecimal(valor:Int) : BigDecimal{
        return BigDecimal(valor)
    }

}