package com.example.calculo.percentual.gordura.components

import com.example.calculo.percentual.gordura.calculadora.DadosCalculo
import com.example.calculo.percentual.gordura.calculadora.Sexo
import java.math.BigDecimal

class DadosCalculoConverter(private var form: DadosCalculoForm) {

    fun converter() : DadosCalculo{
       val numeroDobrasCutaneas : Int = 3

        return DadosCalculo(
            sexo(),
            numeroDobrasCutaneas,
            toInt(form.idade),
            toBigDecimal(form.peso),
            toBigDecimal(form.triceps),
            toBigDecimal(form.subescapular),
            toBigDecimal(form.abdominal),
            toBigDecimal(form.supra),
            toBigDecimal(form.coxa)
        )


    }

    private fun toBigDecimal(editText: String): BigDecimal {
        return if (editText != "") editText.toString()
            .toBigDecimal() else BigDecimal.ZERO
    }

    private fun toInt(editText: String): Int {
        return if (editText != "") editText.toString().toInt() else 0
    }

    private fun sexo(): Sexo {
        return if (form.isSexoMasculino()) Sexo.MASCULINO else Sexo.FEMININO
    }
}