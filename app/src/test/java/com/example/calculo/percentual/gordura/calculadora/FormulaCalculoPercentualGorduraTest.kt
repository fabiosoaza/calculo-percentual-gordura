package com.example.calculo.percentual.gordura.calculadora

import org.junit.Assert.assertEquals
import org.junit.Test


class FormulaCalculoPercentualGorduraTest {
    @Test
    fun deveCalcularOPercentualDeGorduraHomem() {
        //1.17136 - 0,06706 log10(TR + SI+AB ) = 1.07
        //[(4.95/1.07) - 4.50] * 100 = 12.61
        val densidade = BigDecimalUtils.arredondar("1.072304248658499446162")
        val esperado = BigDecimalUtils.arredondar("11.62271633192459")
        val calculo =  CalculoPercentualGordura(densidade).calcular()
        assertEquals(esperado, calculo)
    }

    @Test
    fun deveCalcularOPercentualDeGorduraMulher() {
        //1,16650- 0,07063 log (CX + SI+ SB)
        //[(4.95/1.07) - 4.50] * 100 = 12.61
        val densidade = BigDecimalUtils.arredondar("1.062170925779150251751")
        val esperado = BigDecimalUtils.arredondar("16.02668928910402")
        val calculo =  CalculoPercentualGordura(densidade).calcular()
        assertEquals(esperado, calculo)
    }

}
