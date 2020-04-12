package com.example.calculo.percentual.gordura


import androidx.test.espresso.intent.Intents
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.calculo.percentual.gordura.calculadora.ClassificacaoPercentualGordura
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.math.BigDecimal

@LargeTest
@RunWith(AndroidJUnit4::class)
class CalculadoraPercentualGorduraTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun deveCalcularPercentualGorduraMasculinaCorretamente() {

        val telaPrincipal = PageMainActivity()
        telaPrincipal.informarIdade(medida("32"))
        telaPrincipal.informarPeso(medida("74"))
        telaPrincipal.informarSupraIliaca(medida("10"))
        telaPrincipal.selecionarSexoMasculino()
        telaPrincipal.informarTriceps(medida("10"))
        telaPrincipal.informarAbdominal(medida("10"))
        telaPrincipal.calcular()

        val telaResultados = PageResultadoActivity()
        telaResultados.verificarDensidadeCorporal(medida("1.07"))
        telaResultados.verificarMassaGorda(medida("8.6"))
        telaResultados.verificarPercentualGordura(medida("11.62"))
        telaResultados.verificarMassaMagra(medida("65.4"))
        telaResultados.verificarPercentualMassaMagra(medida("88.38"))
        telaResultados.verificarPesoIdeal(medida("76.94"))
        telaResultados.verificarPesoExcesso(medida("-2.94"))
        telaResultados.verificarClassificacao(ClassificacaoPercentualGordura.MEDIA)
    }

    @Test
    fun deveCalcularPercentualGorduraFeminina() {

        val telaPrincipal = PageMainActivity()
        telaPrincipal.informarIdade(medida("32"))
        telaPrincipal.informarPeso(medida("55"))
        telaPrincipal.informarSupraIliaca(medida("10"))
        telaPrincipal.selecionarSexoFeminino()
        telaPrincipal.informarSubscapular(medida("10"))
        telaPrincipal.informarCoxa(medida("10"))

        telaPrincipal.calcular()

        val telaResultados = PageResultadoActivity()
        telaResultados.verificarDensidadeCorporal(medida("1.06"))
        telaResultados.verificarMassaGorda(medida("8.81"))
        telaResultados.verificarPercentualGordura(medida("16.03"))
        telaResultados.verificarMassaMagra(medida("46.19"))
        telaResultados.verificarPercentualMassaMagra(medida("83.97"))
        telaResultados.verificarPesoIdeal(medida("61.58"))
        telaResultados.verificarPesoExcesso(medida("-6.58"))
        telaResultados.verificarClassificacao(ClassificacaoPercentualGordura.MEDIA)
    }

    @Test
    fun deveExibirMensagemErroCampoIdadeMasculino() {
        val telaPrincipal = PageMainActivity()
        telaPrincipal.selecionarSexoMasculino()
        telaPrincipal.calcular()
        telaPrincipal.verificarMensagemValidacaoIdade()
        val telaResultados = PageResultadoActivity()
        telaResultados.verificarActivityNaoEstaAberta()
    }

    @Test
    fun deveExibirMensagemErroCampoIdadeFeminino() {
        val telaPrincipal = PageMainActivity()
        telaPrincipal.selecionarSexoFeminino()
        telaPrincipal.calcular()
        telaPrincipal.verificarMensagemValidacaoIdade()
        val telaResultados = PageResultadoActivity()
        telaResultados.verificarActivityNaoEstaAberta()
    }

    @Test
    fun deveExibirMensagemErroCampoPesoMasculino() {
        val telaPrincipal = PageMainActivity()
        telaPrincipal.selecionarSexoMasculino()
        telaPrincipal.informarIdade(medida("32"))
        telaPrincipal.calcular()
        telaPrincipal.verificarMensagemValidacaoPeso()
        val telaResultados = PageResultadoActivity()
        telaResultados.verificarActivityNaoEstaAberta()
    }

    @Test
    fun deveExibirMensagemErroCampoPesoFeminino() {
        val telaPrincipal = PageMainActivity()
        telaPrincipal.selecionarSexoFeminino()
        telaPrincipal.informarIdade(medida("32"))
        telaPrincipal.calcular()
        telaPrincipal.verificarMensagemValidacaoPeso()
        val telaResultados = PageResultadoActivity()
        telaResultados.verificarActivityNaoEstaAberta()
    }

    @Test
    fun deveExibirMensagemSupraMasculino() {
        val telaPrincipal = PageMainActivity()
        telaPrincipal.selecionarSexoMasculino()
        telaPrincipal.informarIdade(medida("32"))
        telaPrincipal.informarPeso(medida("74"))
        telaPrincipal.calcular()
        telaPrincipal.verificarMensagemValidacaoSupraIliaca()
        val telaResultados = PageResultadoActivity()
        telaResultados.verificarActivityNaoEstaAberta()
    }

    @Test
    fun deveExibirMensagemSupraFeminino() {
        val telaPrincipal = PageMainActivity()
        telaPrincipal.selecionarSexoFeminino()
        telaPrincipal.informarIdade(medida("32"))
        telaPrincipal.informarPeso(medida("74"))
        telaPrincipal.calcular()
        telaPrincipal.verificarMensagemValidacaoSupraIliaca()
        val telaResultados = PageResultadoActivity()
        telaResultados.verificarActivityNaoEstaAberta()
    }

    @Test
    fun deveExibirMensagemErroCampoTriceps() {
        val telaPrincipal = PageMainActivity()
        telaPrincipal.selecionarSexoMasculino()
        telaPrincipal.informarIdade(medida("32"))
        telaPrincipal.informarPeso(medida("74"))
        telaPrincipal.informarSupraIliaca(medida("10"))
        telaPrincipal.calcular()
        telaPrincipal.verificarMensagemValidacaoTriceps()
        val telaResultados = PageResultadoActivity()
        telaResultados.verificarActivityNaoEstaAberta()
    }

    @Test
    fun deveExibirMensagemErroCampoAbdominal() {
        val telaPrincipal = PageMainActivity()
        telaPrincipal.selecionarSexoMasculino()
        telaPrincipal.informarIdade(medida("32"))
        telaPrincipal.informarPeso(medida("74"))
        telaPrincipal.informarSupraIliaca(medida("10"))
        telaPrincipal.informarTriceps(medida("10"))
        telaPrincipal.calcular()
        telaPrincipal.verificarMensagemValidacaoAbdominal()
        val telaResultados = PageResultadoActivity()
        telaResultados.verificarActivityNaoEstaAberta()
    }

    @Test
    fun deveExibirMensagemErroCampoSubscapular() {
        val telaPrincipal = PageMainActivity()
        telaPrincipal.selecionarSexoFeminino()
        telaPrincipal.informarIdade(medida("32"))
        telaPrincipal.informarPeso(medida("74"))
        telaPrincipal.informarSupraIliaca(medida("10"))
        telaPrincipal.calcular()
        telaPrincipal.verificarMensagemValidacaoSubscapular()
        val telaResultados = PageResultadoActivity()
        telaResultados.verificarActivityNaoEstaAberta()
    }

    @Test
    fun deveExibirMensagemErroCampoCoxa() {
        val telaPrincipal = PageMainActivity()
        telaPrincipal.selecionarSexoFeminino()
        telaPrincipal.informarIdade(medida("32"))
        telaPrincipal.informarPeso(medida("74"))
        telaPrincipal.informarSupraIliaca(medida("10"))
        telaPrincipal.informarSubscapular(medida("10"))
        telaPrincipal.calcular()
        telaPrincipal.verificarMensagemValidacaoCoxa()
        val telaResultados = PageResultadoActivity()
        telaResultados.verificarActivityNaoEstaAberta()
    }



    private fun medida(valor: String): BigDecimal {
        return BigDecimal(valor)
    }


}
