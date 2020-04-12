package com.example.calculo.percentual.gordura.utils

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class FormatUtils {
    companion object {
        fun formatarValor(valor: BigDecimal): String {
            val decimalFormatSymbols: DecimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.getDefault())
            return DecimalFormat("#.##", decimalFormatSymbols).format(valor)
        }
    }

}