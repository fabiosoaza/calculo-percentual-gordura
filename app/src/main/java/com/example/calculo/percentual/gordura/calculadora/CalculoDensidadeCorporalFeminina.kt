package com.example.calculo.percentual.gordura.calculadora

import java.math.BigDecimal
import kotlin.math.log10

class CalculoDensidadeCorporalFeminina(var medidaCoxa: BigDecimal, var medidaSupraIliaca:BigDecimal, var medidaSubescapular:BigDecimal) :  CalculoDensidadeCorporal {
    override fun calcular(): BigDecimal {
        val primeiroValor = BigDecimalUtils.arredondar("1.16650")
        val segundoValor = BigDecimalUtils.arredondar("0.07063")
        val somaMedidas = BigDecimalUtils.arredondar(medidaCoxa + medidaSupraIliaca + medidaSubescapular)
        val calculo = primeiroValor - (segundoValor * (BigDecimalUtils.arredondar(log10(somaMedidas.toDouble()))))
        return BigDecimalUtils.arredondar(calculo)
    }
}