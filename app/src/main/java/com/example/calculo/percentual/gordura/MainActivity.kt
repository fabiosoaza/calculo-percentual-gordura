package com.example.calculo.percentual.gordura

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.calculo.percentual.gordura.calculadora.DadosCalculo
import com.example.calculo.percentual.gordura.components.DadosCalculoConverter
import com.example.calculo.percentual.gordura.components.DadosCalculoForm
import com.example.calculo.percentual.gordura.components.ValidadorDadosCalculoForm
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCalcular.setOnClickListener(View.OnClickListener {
            val form = DadosCalculoForm(this)
            val validador =ValidadorDadosCalculoForm(form)
            if (validador.validar()) {
                abrirResultado(DadosCalculoConverter(form).converter()
                )
            }
        })

        editIdade.addTextChangedListener(clearErrorMessage(layoutEditIdade))
        editPeso.addTextChangedListener(clearErrorMessage(layoutEditPeso))
        editSupra.addTextChangedListener(clearErrorMessage(layoutEditSupra))
        editTriceps.addTextChangedListener(clearErrorMessage(layoutEditTriceps))
        editAbdominal.addTextChangedListener(clearErrorMessage(layoutEditAbdominal))
        editSubescapular.addTextChangedListener(clearErrorMessage(layoutEditSubescapular))
        editCoxa.addTextChangedListener(clearErrorMessage(layoutEditCoxa))

        radioGoupSexo.setOnCheckedChangeListener(clearErrorMessageOnCheck(this))
    }

    private fun abrirResultado(dadosCalculo : DadosCalculo) {
        val resultado = Intent(this, ResultadoActivity::class.java)
        resultado.putExtra("dadosCalculo", dadosCalculo)
        startActivity(resultado)
    }

    private fun clearErrorMessageOnCheck(activity:AppCompatActivity): RadioGroup.OnCheckedChangeListener {
        return RadioGroup.OnCheckedChangeListener { _, _ ->
            val form = DadosCalculoForm( activity )
            if (form.isSexoMasculino()) {
                layoutEditSubescapular.error = ""
                layoutEditCoxa.error = ""
            } else {
                layoutEditTriceps.error = ""
                layoutEditAbdominal.error = ""
            }
        }
    }

    private fun clearErrorMessage(text:TextInputLayout): TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int ) { }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int ) {
                text.error = ""
            }
        }
    }


}
