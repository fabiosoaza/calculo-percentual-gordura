package com.example.calculo.percentual.gordura

import com.example.calculo.percentual.gordura.utils.FormatadorUtils
import java.math.BigDecimal
import java.text.MessageFormat

class PageMainActivity {

    fun informarIdade(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.scrollToElement(R.id.editIdade)
        ExpressoElementUtils.preencherEditText(R.id.editIdade, valor)
    }

    fun verificarMensagemValidacaoIdade() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelIdade), R.id.layoutEditIdade)
    }

    fun informarPeso(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.scrollToElement(R.id.editPeso)
        ExpressoElementUtils.preencherEditText(R.id.editPeso, valor)
    }

    fun verificarMensagemValidacaoPeso() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelPeso), R.id.layoutEditPeso)
    }

    fun informarSupraIliaca(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.scrollToElement(R.id.editSupra)
        ExpressoElementUtils.preencherEditText(R.id.editSupra, valor)
    }

    fun verificarMensagemValidacaoSupraIliaca() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelSupraIliaca), R.id.layoutEditSupra)
    }

    fun selecionarSexoMasculino() {
        ExpressoElementUtils.scrollToElement(R.id.radioMasculino)
        ExpressoElementUtils.marcarRadio(R.id.radioMasculino)
    }

    fun selecionarSexoFeminino() {
        ExpressoElementUtils.scrollToElement(R.id.radioFeminino)
        ExpressoElementUtils.marcarRadio(R.id.radioFeminino)
    }

    fun informarTriceps(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.scrollToElement(R.id.editTriceps)
        ExpressoElementUtils.preencherEditText(R.id.editTriceps, valor)
    }

    fun verificarMensagemValidacaoTriceps() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelTriceps), R.id.layoutEditTriceps)
    }

    fun informarSubscapular(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.scrollToElement(R.id.editSubescapular)
        ExpressoElementUtils.preencherEditText(R.id.editSubescapular, valor)
    }

    fun verificarMensagemValidacaoSubscapular() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelSubescapular), R.id.layoutEditSubescapular)
    }

    fun informarCoxa(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.scrollToElement(R.id.editCoxa)
        ExpressoElementUtils.preencherEditText(R.id.editCoxa, valor)
    }

    fun verificarMensagemValidacaoCoxa() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelCoxa), R.id.layoutEditCoxa)
    }


    fun informarAbdominal(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.scrollToElement(R.id.editAbdominal)
        ExpressoElementUtils.preencherEditText(R.id.editAbdominal, valor)
    }

    fun verificarMensagemValidacaoAbdominal() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelAbnominal), R.id.layoutEditAbdominal)
    }

    fun calcular() {
        ExpressoElementUtils.scrollToElement(R.id.btnCalcular)
        ExpressoElementUtils.clicarBotao(R.id.btnCalcular)
    }

    private fun formatarMedida(medida: BigDecimal): String {
        return FormatadorUtils.formatarValor(medida)
    }

    private fun verificarMensagemErroCampo(fieldName:String, textLayoutErroId:Int){
        val texto = ExpressoElementUtils.getString(R.string.labelMessageErrorMandatory)
        val mensagem = MessageFormat.format(texto, fieldName)
        ExpressoElementUtils.scrollToElement(textLayoutErroId)
        ExpressoElementUtils.verificarErroTexto(textLayoutErroId, mensagem)
    }




}