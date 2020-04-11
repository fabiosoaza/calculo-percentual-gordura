package com.example.calculo.percentual.gordura

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculo.percentual.gordura.calculadora.CalculadoraResultado
import com.example.calculo.percentual.gordura.calculadora.DadosCalculo
import com.example.calculo.percentual.gordura.calculadora.Resultado
import com.example.calculo.percentual.gordura.utils.FormatUtils

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        atualizarResultados(dadosCalculo())
    }

    private fun atualizarResultados(dadosCalculo: DadosCalculo) {
        val resultados = CalculadoraResultado().calcularResultados(dadosCalculo)
        atualizarTextViews(resultados)
    }

    private fun atualizarTextViews(resultado:Resultado) {
        val textViewResultadoDensidadeCorporal = findViewById<TextView>(R.id.textViewResultadoDensidadeCorporal)
        val textViewResultadoMassaGorda = findViewById<TextView>(R.id.textViewResultadoMassaGorda)
        val textViewResultadoMassaMagra = findViewById<TextView>(R.id.textViewResultadoMassaMagra)
        val textViewResultadoPercentualGordura = findViewById<TextView>(R.id.textViewResultadoPercentualGordura)

        val textViewResultadoPercentualMassaMagra = findViewById<TextView>(R.id.textViewResultadoPercentualMassaMagra)
        val textViewResultadoPesoIdeal = findViewById<TextView>(R.id.textViewResultadoPesoIdeal)
        val textViewResultadoPesoExcesso = findViewById<TextView>(R.id.textViewResultadoPesoExcesso)
        val textViewResultadoClassificacao = findViewById<TextView>(R.id.textViewResultadoClassificacao)

        textViewResultadoDensidadeCorporal.text = FormatUtils.formatarValor(resultado.densidadeCorporal)
        textViewResultadoMassaGorda.text = FormatUtils.formatarValor(resultado.pesoGordo)
        textViewResultadoMassaMagra.text = FormatUtils.formatarValor(resultado.massaMagra)
        textViewResultadoPercentualGordura.text = FormatUtils.formatarValor(resultado.percentualGorduraCorporal)

        textViewResultadoPercentualMassaMagra.text = FormatUtils.formatarValor(resultado.percentualMassaMagra)
        textViewResultadoPesoIdeal.text = FormatUtils.formatarValor(resultado.pesoIdeal)
        textViewResultadoPesoExcesso.text = FormatUtils.formatarValor(resultado.pesoExcesso)
        textViewResultadoClassificacao.text = FormatUtils.formatarClassificacao(this, resultado.classificacao)


     }



    private fun dadosCalculo(): DadosCalculo {
        return intent.getParcelableExtra<DadosCalculo>("dadosCalculo")
    }


}
