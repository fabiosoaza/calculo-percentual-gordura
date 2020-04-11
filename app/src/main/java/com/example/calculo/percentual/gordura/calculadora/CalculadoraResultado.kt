package com.example.calculo.percentual.gordura.calculadora

import java.math.BigDecimal

class CalculadoraResultado {

    fun calcularResultados(dadosCalculo: DadosCalculo): Resultado {
        val densidade = calculadoraDensidade(dadosCalculo).calcular()
        val percentualGorduraCorporal = calcularGorduraCorporal(densidade)
        val calculadoraComposicaoCorporal = calcularComposicaoCorporal(percentualGorduraCorporal, dadosCalculo)
        val gorduraAbsoluta = calculadoraComposicaoCorporal.calcularGorduraAbsoluta()
        val massaMagra = calculadoraComposicaoCorporal.calcularMassaMagra()
        val percentualMassaMagra = calculadoraComposicaoCorporal.calcularPercentualMassaMagra()
        val pesoExcesso = calculadoraComposicaoCorporal.calcularPesoExcesso()
        val pesoIdeal = calculadoraComposicaoCorporal.calcularPesoIdeal()
        val classificacao = classificar(dadosCalculo.sexo, percentualGorduraCorporal)

        return Resultado(
            densidade,
            percentualGorduraCorporal,
            gorduraAbsoluta,
            massaMagra,
            percentualMassaMagra,
            pesoExcesso,
            pesoIdeal,
            classificacao
        )
    }

    private fun classificar(sexo:Sexo, percentualGordura:BigDecimal): ClassificacaoPercentualGordura {
        return ClassificadoraPercentualGordura().classificar(sexo, percentualGordura)
    }

    private fun calcularComposicaoCorporal(percentualGorduraCorporal: BigDecimal, dadosCalculo: DadosCalculo ) : CalculoComposicaoCorporal {
        return CalculoComposicaoCorporal(
            percentualGorduraCorporal,
            dadosCalculo.peso,
            dadosCalculo.sexo
        )
    }

    private fun calcularGorduraCorporal(densidade: BigDecimal): BigDecimal {
        return CalculoPercentualGordura(densidade).calcular()
    }

    private fun calculadoraDensidade(dadosCalculo: DadosCalculo): CalculoDensidadeCorporal {
        return if (dadosCalculo.sexo == Sexo.MASCULINO) {
            CalculoDensidadeCorporalMasculina(
                dadosCalculo.medidaTriceps,
                dadosCalculo.mediadaSupraIliaca,
                dadosCalculo.medidaAbnominal
            )
        } else {
            CalculoDensidadeCorporalFeminina(
                dadosCalculo.medidaCoxa,
                dadosCalculo.mediadaSupraIliaca,
                dadosCalculo.medidaSubscapular
            )
        }
    }

}