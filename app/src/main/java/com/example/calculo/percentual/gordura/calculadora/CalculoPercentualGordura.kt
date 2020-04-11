package com.example.calculo.percentual.gordura.calculadora

import com.example.calculo.percentual.gordura.utils.BigDecimalUtils
import java.math.BigDecimal

data class CalculoPercentualGordura(var densidade: BigDecimal) {

    fun calcular():BigDecimal{
        val primeiroValor = BigDecimalUtils.arredondar("4.95")
        val segundoValor =
            BigDecimalUtils.arredondar("4.5")
        val terceiroValor = BigDecimalUtils.arredondar(100)
        //G%=[(4.95/DENSIDADE C.) - 4.50] X 100
        val percentual = (((primeiroValor / BigDecimalUtils.arredondar(densidade)) - segundoValor)) * terceiroValor
        return BigDecimalUtils.arredondar(percentual)
    }
}