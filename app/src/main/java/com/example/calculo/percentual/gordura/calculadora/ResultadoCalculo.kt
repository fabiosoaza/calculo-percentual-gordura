package com.example.calculo.percentual.gordura.calculadora

import java.math.BigDecimal

data class ResultadoCalculo(var densidadeCorporal: BigDecimal, var percentualGorduraCorporal:BigDecimal, var pesoGordo:BigDecimal, var massaMagra:BigDecimal, var percentualMassaMagra: BigDecimal, var pesoExcesso:BigDecimal, var pesoIdeal:BigDecimal, var classificacao:ClassificacaoPercentualGordura) {

}