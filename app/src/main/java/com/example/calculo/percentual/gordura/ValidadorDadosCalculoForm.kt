package com.example.calculo.percentual.gordura

class ValidadorDadosCalculoForm(private var form: DadosCalculoForm) {


    fun validar(): Boolean{
        form.limparMensagemErro()
        return validarCamposBasicos() &&
                if (form.isSexoMasculino()) this.validarCamposMasculino() else this.validarCamposFeminino()
    }

    private fun validarCamposBasicos(): Boolean {
        if (isEmpty(form.idade)) {
            form.exibirMensagemErroIdade()
            return false
        }
        if (isEmpty(form.peso)) {
            form.exibirMensagemErroPeso()
            return false
        }
        if (isEmpty(form.supra)) {
            form.exibirMensagemErroSupra()
            return false
        }
        return true
    }

    private fun validarCamposMasculino(): Boolean {
        if (isEmpty(form.triceps)) {
            form.exibirMensagemErroTriceps()
            return false
        }
        if (isEmpty(form.abdominal)) {
            form.exibirMensagemErroAbdominal()
            return false
        }
        return true
    }

    private fun validarCamposFeminino(): Boolean {
        if (isEmpty(form.subescapular)) {
            form.exibirMensagemErroSubescapular()
            return false
        }
        if (isEmpty(form.coxa)) {
            form.exibirMensagemErroCoxa()
            return false
        }
        return true
    }



    private fun isEmpty(valor: String) = valor == ""



}