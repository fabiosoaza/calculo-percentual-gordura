package com.example.calculo.percentual.gordura.calculadora

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import java.math.BigDecimal


class ClassificadoraPercentualGorduraTest {
    @Test
    fun deveClassificarPercentualGorduraMasculinoMagro() {
        assertEquals(ClassificacaoPercentualGordura.MAGRO, classificarMasculino(BigDecimal(4)))
        assertEquals(ClassificacaoPercentualGordura.MAGRO, classificarMasculino(BigDecimal(4.5)))
    }

    @Test
    fun deveClassificarPercentualGorduraMasculinoAbaixoMedia() {
        assertEquals(ClassificacaoPercentualGordura.ABAIXO_MEDIA, classificarMasculino(BigDecimal(5)))
        assertEquals(ClassificacaoPercentualGordura.ABAIXO_MEDIA, classificarMasculino(BigDecimal(8.5)))
    }

    @Test
    fun deveClassificarPercentualGorduraMasculinoMedia() {
        assertEquals(ClassificacaoPercentualGordura.MEDIA, classificarMasculino(BigDecimal(9)))
        assertEquals(ClassificacaoPercentualGordura.MEDIA, classificarMasculino(BigDecimal(16.5)))
    }

    @Test
    fun deveClassificarPercentualGorduraMasculinoAcimaMedia() {
        assertEquals(ClassificacaoPercentualGordura.ACIMA_MEDIA, classificarMasculino(BigDecimal(17)))
        assertEquals(ClassificacaoPercentualGordura.ACIMA_MEDIA, classificarMasculino(BigDecimal(24.5)))
    }

    @Test
    fun deveClassificarPercentualGoduraMasculinoObeso() {
        assertEquals(ClassificacaoPercentualGordura.OBESO, classificarMasculino(BigDecimal(25)))
        assertEquals(ClassificacaoPercentualGordura.OBESO, classificarMasculino(BigDecimal(100.5)))
    }

    @Test
    fun deveClassificarPercentualGorduraFemininoMagro() {
        assertEquals(ClassificacaoPercentualGordura.MAGRO, classificarFeminino(BigDecimal(8)))
        assertEquals(ClassificacaoPercentualGordura.MAGRO, classificarFeminino(BigDecimal(8.5)))
    }

    @Test
    fun deveClassificarPercentualGorduraFemininoAbaixoMedia() {
        assertEquals(ClassificacaoPercentualGordura.ABAIXO_MEDIA, classificarFeminino(BigDecimal(9)))
        assertEquals(ClassificacaoPercentualGordura.ABAIXO_MEDIA, classificarFeminino(BigDecimal(14.5)))
    }

    @Test
    fun deveClassificarPercentualGorduraFemininoMedia() {
        assertEquals(ClassificacaoPercentualGordura.MEDIA, classificarFeminino(BigDecimal(15)))
        assertEquals(ClassificacaoPercentualGordura.MEDIA, classificarFeminino(BigDecimal(22.5)))
    }

    @Test
    fun deveClassificarPercentualGorduraFemininoAcimaMedia() {
        assertEquals(ClassificacaoPercentualGordura.ACIMA_MEDIA, classificarFeminino(BigDecimal(23)))
        assertEquals(ClassificacaoPercentualGordura.ACIMA_MEDIA, classificarFeminino(BigDecimal(29.5)))
    }

    @Test
    fun deveClassificarPercentualGoduraFemininoObeso() {
        assertEquals(ClassificacaoPercentualGordura.OBESO, classificarFeminino(BigDecimal(30)))
        assertEquals(ClassificacaoPercentualGordura.OBESO, classificarFeminino(BigDecimal(31.5)))
    }

    private fun classificarMasculino(percentualGordura:BigDecimal): ClassificacaoPercentualGordura {
        return ClassificadoraPercentualGordura().classificar(Sexo.MASCULINO, percentualGordura)
    }

    private fun classificarFeminino(percentualGordura:BigDecimal): ClassificacaoPercentualGordura {
        return ClassificadoraPercentualGordura().classificar(Sexo.FEMININO, percentualGordura)
    }



}
