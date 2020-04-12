package com.example.calculo.percentual.gordura

import com.example.calculo.percentual.gordura.utils.FormatUtils
import java.math.BigDecimal
import java.text.MessageFormat

class PageMainActivity {

    fun informarIdade(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editIdade, valor)
    }

    fun verificarMensagemValidacaoIdade() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelIdade), R.id.textViewMessageError)
    }

    fun informarPeso(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editPeso, valor)
    }

    fun verificarMensagemValidacaoPeso() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelPeso), R.id.textViewMessageError)
    }

    fun informarSupraIliaca(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editSupra, valor)
    }

    fun verificarMensagemValidacaoSupraIliaca() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelSupraIliaca), R.id.textViewMessageError)
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

    fun verificarMensagemValidacaoTriceps() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelTriceps), R.id.textViewMessageError)
    }

    fun informarSubscapular(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editSubescapular, valor)
    }

    fun verificarMensagemValidacaoSubscapular() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelSubescapular), R.id.textViewMessageError)
    }

    fun informarCoxa(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editCoxa, valor)
    }

    fun verificarMensagemValidacaoCoxa() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelCoxa), R.id.textViewMessageError)
    }


    fun informarAbdominal(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editAbdominal, valor)
    }

    fun verificarMensagemValidacaoAbdominal() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelAbnominal), R.id.textViewMessageError)
    }

    fun calcular() {
        ExpressoElementUtils.clicarBotao(R.id.btnCalcular)
    }

    private fun formatarMedida(medida: BigDecimal): String {
        return FormatUtils.formatarValor(medida)
    }

    private fun verificarMensagemErroCampo(fieldName:String, textViewMensagemId:Int){
        ExpressoElementUtils.verificarElementoEstaSendoExibido(textViewMensagemId)
        val texto = ExpressoElementUtils.getString(R.string.labelMessageErrorMandatory)
        val mensagem = MessageFormat.format(texto, fieldName)
        ExpressoElementUtils.verificarTextoElemento(textViewMensagemId, mensagem)
    }




}