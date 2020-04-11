package com.example.calculo.percentual.gordura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.example.calculo.percentual.gordura.calculadora.DadosCalculo
import com.example.calculo.percentual.gordura.calculadora.Sexo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCalcular.setOnClickListener(View.OnClickListener {
            val radio = findViewById<RadioButton>(radioGoupSexo.checkedRadioButtonId)
            val sexo = sexo(radio)
            val dadosCalculo = dadosCalculo(sexo)
            val intentResultado = Intent(this, ResultadoActivity::class.java)
            intentResultado.putExtra("dadosCalculo", dadosCalculo)
            startActivity(intentResultado)
        })
    }

    private fun dadosCalculo(sexo: Sexo): DadosCalculo {
        val numeroDobrasCutaneas = 3
        return DadosCalculo(
            sexo,
            numeroDobrasCutaneas,
            editIdade.text.toString().toInt(),
            editPeso.text.toString().toBigDecimal(),
            editTriceps.text.toString().toBigDecimal(),
            editSubescapular.text.toString().toBigDecimal(),
            editAbdominal.text.toString().toBigDecimal(),
            editSupra.text.toString().toBigDecimal(),
            editCoxa.text.toString().toBigDecimal()
        )
    }

    private fun sexo(radio: RadioButton): Sexo {
        return if (getString(R.string.labelSexoMasculino) == radio.text.toString()) Sexo.MASCULINO else Sexo.FEMININO
    }
}
