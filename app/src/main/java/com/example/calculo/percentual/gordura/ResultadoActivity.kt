package com.example.calculo.percentual.gordura

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculo.percentual.gordura.calculadora.CalculadoraResultado
import com.example.calculo.percentual.gordura.calculadora.DadosCalculo
import com.example.calculo.percentual.gordura.calculadora.Resultado
import com.example.calculo.percentual.gordura.utils.ClassificacaoUtils
import com.example.calculo.percentual.gordura.utils.FormatUtils
import kotlinx.android.synthetic.main.activity_resultado.*
import java.math.BigDecimal

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
        val resultados = CalculadoraResultado().calcularResultados(dadosCalculo)
        atualizarTextViews(resultados)
    }

    private fun atualizarTextViews(resultado:Resultado) {
        atualizarValorNumerico(R.id.textViewResultadoDensidadeCorporal, resultado.densidadeCorporal)
        atualizarValorNumerico(R.id.textViewResultadoMassaGorda, resultado.pesoGordo)
        atualizarValorNumerico(R.id.textViewResultadoMassaMagra, resultado.massaMagra)
        atualizarValorNumerico(R.id.textViewResultadoPercentualGordura, resultado.percentualGorduraCorporal)
        atualizarValorNumerico(R.id.textViewResultadoPercentualMassaMagra, resultado.percentualMassaMagra)
        atualizarValorNumerico(R.id.textViewResultadoPesoIdeal, resultado.pesoIdeal)
        atualizarValorNumerico(R.id.textViewResultadoPesoExcesso, resultado.pesoExcesso)
        atualizarTexto(R.id.textViewResultadoClassificacao, getString(ClassificacaoUtils.getResourceIdByClassificacao(resultado.classificacao)))
     }

    private fun atualizarValorNumerico(viewId: Int, valor: BigDecimal) {
        atualizarTexto(viewId, FormatUtils.formatarValor(valor))
    }

    private fun atualizarTexto(viewId: Int, texto: String) {
        val textViewResultadoDensidadeCorporal = findViewById<TextView>(viewId)
        textViewResultadoDensidadeCorporal.text = texto
    }


    private fun dadosCalculo(): DadosCalculo {
        return intent.getParcelableExtra<DadosCalculo>("dadosCalculo")
    }


}
