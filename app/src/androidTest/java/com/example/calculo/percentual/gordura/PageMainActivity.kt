package com.example.calculo.percentual.gordura

import com.example.calculo.percentual.gordura.utils.FormatUtils
import java.math.BigDecimal

class PageMainActivity {

    fun informarIdade(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editIdade, valor)
    }

    fun informarPeso(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editPeso, valor)
    }

    fun informarSupraIliaca(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editSupra, valor)
    }

    fun selecionarSexoMasculino() {
        ExpressoElementUtils.marcarRadio(R.id.radioMasculino)
    }

    fun selecionarSexoFeminino() {
        ExpressoElementUtils.marcarRadio(R.id.radioFeminino)
    }

    fun informarTriceps(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editTriceps, valor)
    }

    fun informarSubscapular(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editSubescapular, valor)
    }

    fun informarCoxa(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editCoxa, valor)
    }

    fun informarAbdominal(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editAbdominal, valor)
    }


    fun calcular() {
        ExpressoElementUtils.clicarBotao(R.id.btnCalcular)
    }

    private fun formatarMedida(medida: BigDecimal): String {
        return FormatUtils.formatarValor(medida)
    }


}