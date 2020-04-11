package com.example.calculo.percentual.gordura.utils

import java.math.BigDecimal
import java.math.RoundingMode

class BigDecimalUtils {
    companion object {
        fun arredondar(valor : Double) : BigDecimal {
            return arredondar(
                BigDecimal(valor),
                16
            )
        }
        fun arredondar(valor : String) : BigDecimal {
            return arredondar(
                BigDecimal(valor),
                16
            )
        }
        fun arredondar(valor : Int) : BigDecimal {
            return arredondar(
                BigDecimal(valor),
                16
            )
        }

        fun arredondar(valor : BigDecimal) : BigDecimal {
            return arredondar(
                valor,
                16
            )
        }

        fun arredondar(valor : BigDecimal, casas:Int) : BigDecimal {
            return valor.setScale(casas, RoundingMode.DOWN)
        }

        fun valorMenorOuIgual(valor1: BigDecimal, valor2: BigDecimal): Boolean {
            return valor1 <= valor2
        }

        fun valorIgual(valor1: BigDecimal, valor2: BigDecimal): Boolean {
            return valor1 == valor2
        }

        fun valorMaiorOuIgual(valor1: BigDecimal, valor2: BigDecimal): Boolean {
            return valor1 >= valor2
        }

        fun valorEntre(valor: BigDecimal, valorInicial: BigDecimal, valorFinal:BigDecimal): Boolean {
            return valorMaiorOuIgual(
                valor,
                valorInicial
            ) && valorMenorOuIgual(
                valor,
                valorFinal
            )
        }

        fun valorMaior(valor1: BigDecimal, valor2: BigDecimal): Boolean {
            return valor1 > valor2
        }

        fun valorMenor(valor1: BigDecimal, valor2: BigDecimal): Boolean {
            return valor1 < valor2
        }



    }

}