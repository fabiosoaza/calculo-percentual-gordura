package com.example.calculo.percentual.gordura.calculadora

import java.math.BigDecimal
import kotlin.math.log10

data class CalculoDensidadeCorporalMasculina(var medidasTriceps: BigDecimal, var medidaSupraIliaca:BigDecimal, var medidaAbdominal:BigDecimal) : CalculoDensidadeCorporal {

    override fun calcular(): BigDecimal {
        val primeiroValor = BigDecimalUtils.arredondar("1.17136")
        val segundoValor = BigDecimalUtils.arredondar("0.06706")
        val somaMedidas = BigDecimalUtils.arredondar(medidasTriceps + medidaSupraIliaca + medidaAbdominal)
        val calculo = primeiroValor - (segundoValor * calcularMedidas(somaMedidas))
        return BigDecimalUtils.arredondar(calculo)
    }

    private fun calcularMedidas(somaMedidas: BigDecimal): BigDecimal {
        return BigDecimalUtils.arredondar(log10(somaMedidas.toDouble()))
    }
}