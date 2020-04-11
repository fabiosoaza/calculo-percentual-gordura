package com.example.calculo.percentual.gordura.calculadora

import com.example.calculo.percentual.gordura.utils.BigDecimalUtils
import java.math.BigDecimal

data class CalculoComposicaoCorporal(var percentualGordura:BigDecimal, var peso:BigDecimal, var sexo:Sexo ) {

    fun calcularGorduraAbsoluta(): BigDecimal {
        return BigDecimalUtils.arredondar(percentualGorduraArredondado() / BigDecimalUtils.arredondar(100) ) * pesoArredondado()
    }

    fun calcularMassaMagra():BigDecimal{
        return pesoArredondado() - calcularGorduraAbsoluta()
    }

    fun calcularPercentualMassaMagra():BigDecimal{
        return BigDecimalUtils.arredondar(100) - percentualGorduraArredondado()
    }

    fun calcularPesoIdeal():BigDecimal{
        return BigDecimalUtils.arredondar(calcularMassaMagra() / quociente())
    }

    fun calcularPesoExcesso():BigDecimal{
        return pesoArredondado() - calcularPesoIdeal()
    }

    private fun quociente(): BigDecimal {
        return if (sexo == Sexo.MASCULINO) BigDecimalUtils.arredondar("0.85") else BigDecimalUtils.arredondar("0.75")
    }

    private fun pesoArredondado() : BigDecimal {
       return  BigDecimalUtils.arredondar(peso)
    }

    private fun percentualGorduraArredondado() : BigDecimal {
        return  BigDecimalUtils.arredondar(percentualGordura)
    }

}