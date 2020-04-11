package com.example.calculo.percentual.gordura.calculadora

import com.example.calculo.percentual.gordura.utils.BigDecimalUtils
import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigDecimal


class CalculadoraResultadoTest {
    @Test
    fun deveCalcularResultadoTesteHomens() {
        val dadosCalculo = DadosCalculo(Sexo.MASCULINO, 3, 32, BigDecimal(74), BigDecimal(10), BigDecimal(10), BigDecimal(10), BigDecimal(10.0), BigDecimal(10.0) )
        val resultado = CalculadoraResultado().calcularResultados(dadosCalculo)
        val pesoGordoEsperado = BigDecimal("8.60")
        val densidadeEsperada = BigDecimal("1.07")
        val massaMagraEsperada = BigDecimal("65.39")
        val percentualMassaMagraEsperada = BigDecimal("88.37")
        val percentualGorduraEsperada = BigDecimal("11.62")
        val pesoIdealEsperado = BigDecimal("76.94")
        val pesoExcessoEsperado = BigDecimal("-2.94")
        val classificacaoEsperada = ClassificacaoPercentualGordura.MEDIA

        assertEquals(densidadeEsperada, arredondar(resultado.densidadeCorporal))
        assertEquals(percentualGorduraEsperada, arredondar(resultado.percentualGorduraCorporal))
        assertEquals(massaMagraEsperada, arredondar(resultado.massaMagra))
        assertEquals(percentualMassaMagraEsperada, arredondar(resultado.percentualMassaMagra))
        assertEquals(pesoGordoEsperado, arredondar(resultado.pesoGordo))
        assertEquals(pesoIdealEsperado, arredondar(resultado.pesoIdeal))
        assertEquals(pesoExcessoEsperado, arredondar(resultado.pesoExcesso))
        assertEquals(classificacaoEsperada, resultado.classificacao)



    }

    @Test
    fun deveCalcularResultadoTesteMulheres() {
        val dadosCalculo = DadosCalculo(Sexo.FEMININO, 3, 32, BigDecimal(55), BigDecimal(10), BigDecimal(10), BigDecimal(10), BigDecimal(10.0), BigDecimal(10.0) )
        val resultado = CalculadoraResultado().calcularResultados(dadosCalculo)
        val percentualGorduraEsperada = BigDecimal("16.02")
        val densidadeEsperada = BigDecimal("1.06")
        val pesoGordoEsperado = BigDecimal("8.81")
        val massaMagraEsperada = BigDecimal("46.18")
        val percentualMassaMagraEsperada = BigDecimal("83.97")
        val pesoIdealEsperado = BigDecimal("61.58")
        val pesoExcessoEsperado = BigDecimal("-6.58")
        val classificacaoEsperada = ClassificacaoPercentualGordura.MEDIA


        assertEquals(densidadeEsperada, arredondar(resultado.densidadeCorporal))
        assertEquals(percentualGorduraEsperada, arredondar(resultado.percentualGorduraCorporal))
        assertEquals(massaMagraEsperada, arredondar(resultado.massaMagra))
        assertEquals(percentualMassaMagraEsperada, arredondar(resultado.percentualMassaMagra))
        assertEquals(pesoGordoEsperado, arredondar(resultado.pesoGordo))
        assertEquals(pesoIdealEsperado, arredondar(resultado.pesoIdeal))
        assertEquals(pesoExcessoEsperado, arredondar(resultado.pesoExcesso))
        assertEquals(classificacaoEsperada, resultado.classificacao)



    }

    private fun arredondar(valor:BigDecimal) : BigDecimal{
        return BigDecimalUtils.arredondar(valor, 2)
    }

}
