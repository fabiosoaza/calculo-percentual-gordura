package com.example.calculo.percentual.gordura


import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class CalculadoraPercentualGorduraTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun deveCalcularPercentualGorduraMasculinaCorretamente() {

        val telaPrincipal = PageMainActivity()
        telaPrincipal.informarIdade("32")
        telaPrincipal.informarPeso("74")
        telaPrincipal.informarSupraIliaca("10")
        telaPrincipal.selecionarSexoMasculino()
        telaPrincipal.informarTriceps("10")
        telaPrincipal.informarSubscapular("10")
        telaPrincipal.informarCoxa("10")
        telaPrincipal.informarAbdominal("10")
        telaPrincipal.calcular()

        val telaResultados = PageResultadoActivity()
        telaResultados.verificarDensidadeCorporal("1,07")
        telaResultados.verificarMassaGorda("8,6")
        telaResultados.verificarPercentualGordura("11,62")
        telaResultados.verificarMassaMagra("65,4")
        telaResultados.verificarPercentualMassaMagra("88,38")
        telaResultados.verificarPesoIdeal("76,94")
        telaResultados.verificarPesoExcesso("-2,94")
        telaResultados.verificarClassificacao("Na Média")
    }

    @Test
    fun deveCalcularPercentualGorduraFeminina() {

        val telaPrincipal = PageMainActivity()
        telaPrincipal.informarIdade("32")
        telaPrincipal.informarPeso("55")
        telaPrincipal.informarSupraIliaca("10")
        telaPrincipal.selecionarSexoFeminino()
        telaPrincipal.informarTriceps("10")
        telaPrincipal.informarSubscapular("10")
        telaPrincipal.informarCoxa("10")
        telaPrincipal.informarAbdominal("10")
        telaPrincipal.calcular()

        val telaResultados = PageResultadoActivity()
        telaResultados.verificarDensidadeCorporal("1,06")
        telaResultados.verificarMassaGorda("8,81")
        telaResultados.verificarPercentualGordura("16,03")
        telaResultados.verificarMassaMagra("46,19")
        telaResultados.verificarPercentualMassaMagra("83,97")
        telaResultados.verificarPesoIdeal("61,58")
        telaResultados.verificarPesoExcesso("-6,58")
        telaResultados.verificarClassificacao("Na Média")
    }




}
