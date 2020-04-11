package com.example.calculo.percentual.gordura.calculadora

import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigDecimal


class CalculoDensidadeCorporalFemininaTest {
    @Test
    fun deveCalcularAsMedidasCorretamente() {
        //1.16650- 0.07063 log10(10 + 10+ 10) validado no site WolframAlfa
        val esperado = BigDecimalUtils.arredondar("1.062170925779150251751")
        val calculo =  CalculoDensidadeCorporalFeminina(BigDecimal(10), BigDecimal(10), BigDecimal(10)).calcular()
        assertEquals(esperado, calculo)
    }

}
