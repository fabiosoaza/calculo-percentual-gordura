package com.example.calculo.percentual.gordura

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.calculo.percentual.gordura.calculadora.CalculadoraResultado
import com.example.calculo.percentual.gordura.calculadora.DadosCalculo
import com.example.calculo.percentual.gordura.components.ResultadosCalculoComponent
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        atualizarResultados(dadosCalculo())
        btnFecharResultados.setOnClickListener(View.OnClickListener {
            finish()
        }
        )
    }

    private fun atualizarResultados(dadosCalculo: DadosCalculo) {
        val resultado = CalculadoraResultado().calcularResultados(dadosCalculo)
        val renderer = ResultadosCalculoComponent(                this)
        renderer.atualizarResultados(resultado)
    }

    private fun dadosCalculo(): DadosCalculo {
        return intent.getParcelableExtra<DadosCalculo>("dadosCalculo")
    }




}
