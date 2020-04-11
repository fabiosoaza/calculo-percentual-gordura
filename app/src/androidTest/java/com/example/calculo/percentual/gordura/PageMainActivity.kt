package com.example.calculo.percentual.gordura

import androidx.test.espresso.action.ViewActions.*

class PageMainActivity {

    fun informarIdade(valor:String){
        ExpressoElementUtils.preencherEditText(R.id.editIdade, valor)
    }

    fun informarPeso(valor:String){
        ExpressoElementUtils.preencherEditText(R.id.editPeso, valor)
    }

    fun informarSupraIliaca(valor:String){
        ExpressoElementUtils.preencherEditText(R.id.editSupra, valor)
    }

    fun selecionarSexoMasculino(){
        ExpressoElementUtils.marcarRadio(R.id.radioMasculino)
    }

    fun selecionarSexoFeminino(){
        ExpressoElementUtils.marcarRadio(R.id.radioFeminino)
    }

    fun informarTriceps(valor:String){
        ExpressoElementUtils.preencherEditText(R.id.editTriceps, valor)
    }

    fun informarSubscapular(valor:String){
        ExpressoElementUtils.preencherEditText(R.id.editSubescapular, valor)
    }

    fun informarCoxa(valor:String){
        ExpressoElementUtils.preencherEditText(R.id.editCoxa, valor)
    }

    fun informarAbdominal(valor:String){
        ExpressoElementUtils.preencherEditText(R.id.editAbdominal, valor)
    }

    fun calcular(){
        ExpressoElementUtils.clicarBotao(R.id.btnCalcular)
    }


}