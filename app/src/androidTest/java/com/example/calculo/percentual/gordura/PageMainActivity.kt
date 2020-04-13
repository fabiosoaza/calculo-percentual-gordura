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
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelIdade), R.id.layoutEditIdade)
    }

    fun informarPeso(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editPeso, valor)
    }

    fun verificarMensagemValidacaoPeso() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelPeso), R.id.layoutEditPeso)
    }

    fun informarSupraIliaca(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editSupra, valor)
    }

    fun verificarMensagemValidacaoSupraIliaca() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelSupraIliaca), R.id.layoutEditSupra)
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
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelTriceps), R.id.layoutEditTriceps)
    }

    fun informarSubscapular(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editSubescapular, valor)
    }

    fun verificarMensagemValidacaoSubscapular() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelSubescapular), R.id.layoutEditSubescapular)
    }

    fun informarCoxa(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editCoxa, valor)
    }

    fun verificarMensagemValidacaoCoxa() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelCoxa), R.id.layoutEditCoxa)
    }


    fun informarAbdominal(medida: BigDecimal) {
        val valor = formatarMedida(medida)
        ExpressoElementUtils.preencherEditText(R.id.editAbdominal, valor)
    }

    fun verificarMensagemValidacaoAbdominal() {
        verificarMensagemErroCampo(ExpressoElementUtils.getString(R.string.labelAbnominal), R.id.layoutEditAbdominal)
    }

    fun calcular() {
        ExpressoElementUtils.clicarBotao(R.id.btnCalcular)
    }

    private fun formatarMedida(medida: BigDecimal): String {
        return FormatUtils.formatarValor(medida)
    }

    private fun verificarMensagemErroCampo(fieldName:String, textLayoutErroId:Int){
        val texto = ExpressoElementUtils.getString(R.string.labelMessageErrorMandatory)
        val mensagem = MessageFormat.format(texto, fieldName)
        ExpressoElementUtils.verificarErroTexto(textLayoutErroId, mensagem)
    }




}