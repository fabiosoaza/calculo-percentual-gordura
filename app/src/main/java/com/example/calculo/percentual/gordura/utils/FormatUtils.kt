package com.example.calculo.percentual.gordura.utils

import android.content.Context
import com.example.calculo.percentual.gordura.R
import com.example.calculo.percentual.gordura.calculadora.ClassificacaoPercentualGordura
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class FormatUtils {
    companion object {
        fun formatarClassificacao(context: Context, classificacao: ClassificacaoPercentualGordura) : String{
            val resourceId = getResourceIdByClassificacao(context, classificacao)
            return context.getString(resourceId)
        }

        fun formatarValor(valor : BigDecimal):String{
            val decimalFormatSymbols: DecimalFormatSymbols =   DecimalFormatSymbols.getInstance(Locale.getDefault())
            return DecimalFormat("#.##", decimalFormatSymbols).format(valor)
        }

        private fun getResourceIdByClassificacao(context: Context, classificacao: ClassificacaoPercentualGordura) : Int{
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