package com.example.calculo.percentual.gordura

import android.annotation.SuppressLint
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
import java.math.BigDecimal
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
        val textView = getTextViewMensagemErro()
        val sexo = extrairSexo()
        return if (sexo == Sexo.MASCULINO) {
            validar(editIdade, textView)
                    && validar(editPeso, textView)
                    && validarMedidasMasculino()
        } else {
            validar(editIdade, textView)
                    && validar(editPeso, textView)
                    && validarMedidasFeminino()
        }

    }



    private fun validarMedidasMasculino() : Boolean{
        val textView = getTextViewMensagemErro()
        return  validar(editSupra, textView)
                && validar(editTriceps, textView)
                && validar(editAbdominal, textView)
    }

    private fun validarMedidasFeminino() : Boolean{
        val textView = getTextViewMensagemErro()
        return validar(editSupra, textView)
                && validar(editSubescapular, textView)
                && validar(editCoxa, textView)
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
        return sexo(radio)
    }

    private fun getTextViewMensagemErro(): TextView {
        val textView = findViewById<TextView>(R.id.textViewMessageError)
        return textView
    }


    private fun dadosCalculo(sexo: Sexo): DadosCalculo {
        val numeroDobrasCutaneas = 3
        val medidaTriceps = if (sexo == Sexo.MASCULINO) editTriceps.text.toString().toBigDecimal() else BigDecimal.ZERO
        val medidaAbnominal = if (sexo == Sexo.MASCULINO) editAbdominal.text.toString().toBigDecimal() else BigDecimal.ZERO
        val medidaSubscapular = if (sexo == Sexo.FEMININO) editSubescapular.text.toString().toBigDecimal() else BigDecimal.ZERO
        val medidaCoxa = if (sexo == Sexo.FEMININO) editCoxa.text.toString().toBigDecimal() else BigDecimal.ZERO
        return DadosCalculo(
            sexo,
            numeroDobrasCutaneas,
            editIdade.text.toString().toInt(),
            editPeso.text.toString().toBigDecimal(),
            medidaTriceps,
            medidaSubscapular,
            medidaAbnominal,
            editSupra.text.toString().toBigDecimal(),
            medidaCoxa

        )
    }

    private fun sexo(radio: RadioButton): Sexo {
        return if (getString(R.string.labelSexoMasculino) == radio.text.toString()) Sexo.MASCULINO else Sexo.FEMININO
    }


}
