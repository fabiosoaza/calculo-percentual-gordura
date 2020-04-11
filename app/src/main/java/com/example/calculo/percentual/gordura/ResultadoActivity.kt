package com.example.calculo.percentual.gordura

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculo.percentual.gordura.calculadora.CalculadoraResultado
import com.example.calculo.percentual.gordura.calculadora.ClassificacaoPercentualGordura
import com.example.calculo.percentual.gordura.calculadora.DadosCalculo
import com.example.calculo.percentual.gordura.calculadora.Resultado
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

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

        textViewResultadoDensidadeCorporal.text = formatar(resultado.densidadeCorporal)
        textViewResultadoMassaGorda.text = formatar(resultado.pesoGordo)
        textViewResultadoMassaMagra.text = formatar(resultado.massaMagra)
        textViewResultadoPercentualGordura.text = formatar(resultado.percentualGorduraCorporal)

        textViewResultadoPercentualMassaMagra.text = formatar(resultado.percentualMassaMagra)
        textViewResultadoPesoIdeal.text = formatar(resultado.pesoIdeal)
        textViewResultadoPesoExcesso.text = formatar(resultado.pesoExcesso)
        textViewResultadoClassificacao.text = formatarClassificacao(resultado.classificacao)


     }

    private fun formatarClassificacao(classificacao:ClassificacaoPercentualGordura) : String{
        return when (classificacao) {
            ClassificacaoPercentualGordura.MAGRO -> getString(R.string.labelClassificaoMagro)
            ClassificacaoPercentualGordura.ABAIXO_MEDIA -> getString(R.string.labelClassificaoAbaixoMedia)
            ClassificacaoPercentualGordura.MEDIA -> getString(R.string.labelClassificaoMedia)
            ClassificacaoPercentualGordura.ACIMA_MEDIA -> getString(R.string.labelClassificaoAcimaMedia)
            ClassificacaoPercentualGordura.OBESO -> getString(R.string.labelClassificacaoObeso)
            else -> throw IllegalArgumentException()
        }
    }

    private fun formatar(valor : BigDecimal):String{
        val decimalFormatSymbols: DecimalFormatSymbols =   DecimalFormatSymbols.getInstance(Locale("pt", "BR"))
        return DecimalFormat("#.##", decimalFormatSymbols).format(valor)
    }

    private fun dadosCalculo(): DadosCalculo {
        return intent.getParcelableExtra<DadosCalculo>("dadosCalculo")
    }


}
