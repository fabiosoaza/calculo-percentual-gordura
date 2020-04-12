package com.example.calculo.percentual.gordura.utils

import com.example.calculo.percentual.gordura.R
import com.example.calculo.percentual.gordura.calculadora.ClassificacaoPercentualGordura

class ClassificacaoUtils {
    companion object {
         fun getResourceIdByClassificacao(classificacao: ClassificacaoPercentualGordura) : Int{
            return when (classificacao) {
                ClassificacaoPercentualGordura.MAGRO -> R.string.labelClassificaoMagro
                ClassificacaoPercentualGordura.ABAIXO_MEDIA -> R.string.labelClassificaoAbaixoMedia
                ClassificacaoPercentualGordura.MEDIA -> R.string.labelClassificaoMedia
                ClassificacaoPercentualGordura.ACIMA_MEDIA -> R.string.labelClassificaoAcimaMedia
                ClassificacaoPercentualGordura.OBESO -> R.string.labelClassificacaoObeso
                else -> throw IllegalArgumentException()
            }
        }

    }
}