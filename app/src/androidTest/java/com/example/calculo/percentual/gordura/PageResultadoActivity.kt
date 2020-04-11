package com.example.calculo.percentual.gordura

class PageResultadoActivity {

     fun verificarDensidadeCorporal(texto:String){
        ExpressoElementUtils.verificarTextoElemento(R.id.textViewResultadoDensidadeCorporal, texto)
    }

    fun verificarMassaGorda(texto:String){
        ExpressoElementUtils.verificarTextoElemento(R.id.textViewResultadoMassaGorda, texto)
    }

    fun verificarPercentualGordura(texto:String){
        ExpressoElementUtils.verificarTextoElemento(R.id.textViewResultadoPercentualGordura, texto)
    }

     fun verificarMassaMagra(texto:String){
        ExpressoElementUtils.verificarTextoElemento(R.id.textViewResultadoMassaMagra, texto)
    }

    fun verificarPercentualMassaMagra(texto:String){
        ExpressoElementUtils.verificarTextoElemento(R.id.textViewResultadoPercentualMassaMagra, texto)
    }

    fun verificarPesoIdeal(texto:String){
        ExpressoElementUtils.verificarTextoElemento(R.id.textViewResultadoPesoIdeal, texto)
    }

    fun verificarPesoExcesso(texto:String){
        ExpressoElementUtils.verificarTextoElemento(R.id.textViewResultadoPesoExcesso, texto)
    }

    fun verificarClassificacao(texto:String){
        ExpressoElementUtils.verificarTextoElemento(R.id.textViewResultadoClassificacao, texto)
    }


}