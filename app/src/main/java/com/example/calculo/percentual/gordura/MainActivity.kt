package com.example.calculo.percentual.gordura

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculo.percentual.gordura.calculadora.DadosCalculo
import com.example.calculo.percentual.gordura.calculadora.Sexo
import kotlinx.android.synthetic.main.activity_main.*
import java.text.MessageFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCalcular.setOnClickListener(View.OnClickListener {
            if (validarCampos()) {
                abrirResultado()
            }
        })
    }

    private fun validarCampos() : Boolean {
        val textView = findViewById<TextView>(R.id.textViewMessageError)
       return validar(editIdade, textView)
               && validar(editPeso, textView)
               && validar(editSupra, textView)
               && validar(editTriceps, textView)
               && validar(editSubescapular, textView)
               && validar(editCoxa, textView)
               && validar(editAbdominal, textView)

    }

    private fun validar(editText: EditText, textViewMessage: TextView) : Boolean{
        textViewMessage.visibility = View.INVISIBLE
        textViewMessage.text = ""
        if(isEmpty(editText)){
            textViewMessage.text = mensagemFormatada(editText.hint.toString())
            textViewMessage.visibility = View.VISIBLE
            editText.requestFocus();
            return false
        }
        return true
    }

    private fun mensagemFormatada(campo:String) : String{
        val message = getString(R.string.labelMessageErrorMandatory)
        return  MessageFormat.format(message, campo)
    }


    private fun isEmpty(editText: EditText) = editText.text.toString() == ""

    private fun abrirResultado() {
        val dadosCalculo = dadosCalculo(extrairSexo())
        val intentResultado = Intent(this, ResultadoActivity::class.java)
        intentResultado.putExtra("dadosCalculo", dadosCalculo)
        startActivity(intentResultado)
    }

    private fun extrairSexo(): Sexo {
        val radio = findViewById<RadioButton>(radioGoupSexo.checkedRadioButtonId)
        val sexo = sexo(radio)
        return sexo
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
