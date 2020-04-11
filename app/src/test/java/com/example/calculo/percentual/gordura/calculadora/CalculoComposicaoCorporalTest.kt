package com.example.calculo.percentual.gordura.calculadora

import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigDecimal


class CalculoComposicaoCorporalTest {
    @Test
    fun deveCalcularAGorduraAbsolutaCorretamente() {
        //validado no site WolframAlfa
        //(11.62/100) x 74
        val percentualGordura =  BigDecimalUtils.arredondar("11.62271633192459")
        val esperado = BigDecimal("8.60")
        val calculo =   CalculoComposicaoCorporal(percentualGordura, BigDecimal(74), Sexo.MASCULINO ).calcularGorduraAbsoluta()
        assertEquals(esperado, BigDecimalUtils.arredondar(calculo,2))
    }

    @Test
    fun deveCalcularAMassaMagra() {
        //validado no site WolframAlfa
        //74 - 8.598...
        val percentualGordura =  BigDecimalUtils.arredondar("11.62271633192459")
        val esperado = BigDecimal("65.39")
        val calculo =   CalculoComposicaoCorporal(percentualGordura, BigDecimal(74), Sexo.MASCULINO ).calcularMassaMagra()
        assertEquals(esperado, BigDecimalUtils.arredondar(calculo,2))
    }

    @Test
    fun deveCalcularPercentualMassaMagra() {
        //validado no site WolframAlfa
        //100 - 11.62
        val percentualGordura =  BigDecimalUtils.arredondar("11.62271633192459")
        val esperado = BigDecimal("88.37")
        val calculo =   CalculoComposicaoCorporal(percentualGordura, BigDecimal(74), Sexo.MASCULINO ).calcularPercentualMassaMagra()
        assertEquals(esperado, BigDecimalUtils.arredondar(calculo,2))
    }

    @Test
    fun deveCalcularPesoIdealHomens() {
        // massa magra / 0,85 validado no site WolframAlfa
        //65.40 / 0.85
        val percentualGordura =  BigDecimalUtils.arredondar("11.62271633192459")
        val esperado = BigDecimal("76.94")
        val calculo =   CalculoComposicaoCorporal(percentualGordura, BigDecimal(74), Sexo.MASCULINO ).calcularPesoIdeal()
        assertEquals(esperado, BigDecimalUtils.arredondar(calculo,2))
    }

    @Test
    fun deveCalcularPesoExcessoHomens() {
        // peso corporal - peso Ideal validado no site WolframAlfa
        //74-76.94
        val percentualGordura =  BigDecimalUtils.arredondar("11.62271633192459")
        val esperado = BigDecimal("-2.94")
        val calculo =   CalculoComposicaoCorporal(percentualGordura, BigDecimal(74), Sexo.MASCULINO ).calcularPesoExcesso()
        assertEquals(esperado, BigDecimalUtils.arredondar(calculo,2))
    }

    @Test
    fun deveCalcularPesoIdealMulheres() {
        val percentualGordura = BigDecimalUtils.arredondar("16.02668928910402")
        val esperado = BigDecimal("61.58")
        val calculo =   CalculoComposicaoCorporal(percentualGordura, BigDecimal(55), Sexo.FEMININO).calcularPesoIdeal()
        assertEquals(esperado, BigDecimalUtils.arredondar(calculo,2))
    }

    @Test
    fun deveCalcularPesoExcessoMulheres() {
        // peso corporal - peso Ideal validado no site WolframAlfa
        val percentualGordura = BigDecimalUtils.arredondar("16.02668928910402")
        val esperado = BigDecimal("-6.58")
        val calculo =   CalculoComposicaoCorporal(percentualGordura, BigDecimal(55), Sexo.FEMININO ).calcularPesoExcesso()
        assertEquals(esperado, BigDecimalUtils.arredondar(calculo,2))
    }

}
