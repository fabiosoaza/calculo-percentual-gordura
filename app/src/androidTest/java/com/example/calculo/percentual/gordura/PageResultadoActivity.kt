package com.example.calculo.percentual.gordura

import androidx.test.InstrumentationRegistry
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import com.example.calculo.percentual.gordura.calculadora.ClassificacaoPercentualGordura
import com.example.calculo.percentual.gordura.utils.ClassificacaoUtils
import com.example.calculo.percentual.gordura.utils.FormatUtils
import org.hamcrest.Matchers.not
import java.math.BigDecimal

class PageResultadoActivity {

    fun verificarActivityNaoEstaAberta() {
        ExpressoElementUtils.verificarElementoNaoExiste(R.id.textviewResultado)
    }

    fun verificarDensidadeCorporal(medida: BigDecimal) {
        val valor = formatarValor(medida)
        ExpressoElementUtils.scrollToElement(R.id.textViewResultadoDensidadeCorporal)
        ExpressoElementUtils.verificarTextoElemento(R.id.textViewResultadoDensidadeCorporal, valor)
    }

    fun verificarMassaGorda(medida: BigDecimal) {
        val valor = formatarValor(medida)
        ExpressoElementUtils.scrollToElement(R.id.textViewResultadoMassaGorda)
        ExpressoElementUtils.verificarTextoElemento(R.id.textViewResultadoMassaGorda, valor)
    }

    fun verificarPercentualGordura(medida: BigDecimal) {
        val valor = formatarValor(medida)
        ExpressoElementUtils.scrollToElement(R.id.textViewResultadoPercentualGordura)
        ExpressoElementUtils.verificarTextoElemento(R.id.textViewResultadoPercentualGordura, valor)
    }

    fun verificarMassaMagra(medida: BigDecimal) {
        val valor = formatarValor(medida)
        ExpressoElementUtils.scrollToElement(R.id.textViewResultadoMassaMagra)
        ExpressoElementUtils.verificarTextoElemento(R.id.textViewResultadoMassaMagra, valor)
    }

    fun verificarPercentualMassaMagra(medida: BigDecimal) {
        val valor = formatarValor(medida)
        ExpressoElementUtils.scrollToElement(R.id.textViewResultadoPercentualMassaMagra)
        ExpressoElementUtils.verificarTextoElemento(R.id.textViewResultadoPercentualMassaMagra,valor)
    }

    fun verificarPesoIdeal(medida: BigDecimal) {
        val valor = formatarValor(medida)
        ExpressoElementUtils.scrollToElement(R.id.textViewResultadoPesoIdeal)
        ExpressoElementUtils.verificarTextoElemento(R.id.textViewResultadoPesoIdeal, valor)
    }

    fun verificarPesoExcesso(medida: BigDecimal) {
        val valor = formatarValor(medida)
        ExpressoElementUtils.scrollToElement(R.id.textViewResultadoPesoExcesso)
        ExpressoElementUtils.verificarTextoElemento(R.id.textViewResultadoPesoExcesso, valor)
    }

    fun verificarClassificacao(classificacao:ClassificacaoPercentualGordura) {
        val context = InstrumentationRegistry.getTargetContext()
        val texto = context.getString(ClassificacaoUtils.getResourceIdByClassificacao(classificacao))
        ExpressoElementUtils.scrollToElement(R.id.textViewResultadoClassificacao)
        ExpressoElementUtils.verificarTextoElemento(R.id.textViewResultadoClassificacao, texto)
    }

    private fun formatarValor(medida: BigDecimal): String {
        return FormatUtils.formatarValor(medida)
    }


}