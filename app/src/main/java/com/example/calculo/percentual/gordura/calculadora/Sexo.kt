package com.example.calculo.percentual.gordura.calculadora

enum class Sexo(var codigo:Int) {
    MASCULINO(1), FEMININO(2);

    companion object {
        fun criar(sexo : Int) : Sexo {
            return if (sexo == MASCULINO.codigo) MASCULINO else FEMININO
        }
    }
}