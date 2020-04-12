package com.example.calculo.percentual.gordura

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.calculo.percentual.gordura.calculadora.DadosCalculo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCalcular.setOnClickListener(View.OnClickListener {
            val form = DadosCalculoForm(this)
            val validador = ValidadorDadosCalculoForm(form)
            if (validador.validar()) {
                abrirResultado(DadosCalculoConverter(form).bind())
            }
        })
    }
    private fun abrirResultado(dadosCalculo : DadosCalculo) {
        val resultado = Intent(this, ResultadoActivity::class.java)
        resultado.putExtra("dadosCalculo", dadosCalculo)
        startActivity(resultado)
    }

}
