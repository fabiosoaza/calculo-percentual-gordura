package com.example.calculo.percentual.gordura.calculadora

import com.example.calculo.percentual.gordura.utils.BigDecimalUtils
import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigDecimal


class CalculoDensidadeCorporalMasculinaTest {
    @Test
    fun deveCalcularAsMedidasCorretamente() {
        //1.17136 – 0.06706 log10(10+10+10) validado no site WolframAlfa
        val esperado = BigDecimalUtils.arredondar("1.072304248658499446162")
        val calculo =  CalculoDensidadeCorporalMasculina(BigDecimal(10), BigDecimal(10), BigDecimal(10)).calcular()
        assertEquals(esperado, calculo)
    }

}
