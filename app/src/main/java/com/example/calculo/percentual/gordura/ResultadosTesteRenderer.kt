package com.example.calculo.percentual.gordura

import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.calculo.percentual.gordura.calculadora.ClassificacaoPercentualGordura
import com.example.calculo.percentual.gordura.calculadora.Resultado
import com.example.calculo.percentual.gordura.utils.ClassificacaoUtils
import com.example.calculo.percentual.gordura.utils.FormatUtils
import java.math.BigDecimal
import java.text.MessageFormat

class ResultadosTesteRenderer(private var view: ComponentActivity) {

    private val textViewResultadoDensidadeCorporal: TextView = view.findViewById<TextView>(R.id.textViewResultadoDensidadeCorporal)
    private val textViewResultadoMassaGorda: TextView = view.findViewById<TextView>(R.id.textViewResultadoMassaGorda)
    private val textViewResultadoMassaMagra: TextView = view.findViewById<TextView>(R.id.textViewResultadoMassaMagra)
    private val textViewResultadoPercentualGordura: TextView = view.findViewById<TextView>(R.id.textViewResultadoPercentualGordura)
    private val textViewResultadoPercentualMassaMagra: TextView = view.findViewById<TextView>(R.id.textViewResultadoPercentualMassaMagra)
    private val textViewResultadoPesoIdeal: TextView = view.findViewById<TextView>(R.id.textViewResultadoPesoIdeal)
    private val textViewResultadoPesoExcesso: TextView = view.findViewById<TextView>(R.id.textViewResultadoPesoExcesso)
    private val textViewResultadoClassificacao: TextView = view.findViewById<TextView>(R.id.textViewResultadoClassificacao)

    private val contentDescriptionResultadoDensidadeCorporal:String = view.getString(R.string.contentDescriptionResultadoDensidadeCorporal)
    private val contentDescriptionResultadoMassaGorda:String = view.getString(R.string.contentDescriptionResultadoMassaGorda)
    private val contentDescriptionResultadoMassaMagra:String = view.getString(R.string.contentDescriptionResultadoMassaMagra)
    private val contentDescriptionResultadoPercentualGordura:String = view.getString(R.string.contentDescriptionResultadoPercentualGordura)
    private val contentDescriptionResultadoPercentualMassaMagra:String = view.getString(R.string.contentDescriptionResultadoPercentualMassaMagra)
    private val contentDescriptionResultadoPesoIdeal:String = view.getString(R.string.contentDescriptionResultadoPesoIdeal)
    private val contentDescriptionResultadoPesoExcessoAbaixoIdeal:String = view.getString(R.string.contentDescriptionResultadoPesoExcessoAbaixoIdeal)
    private val contentDescriptionResultadoPesoExcessoAcimaIdeal:String = view.getString(R.string.contentDescriptionResultadoPesoExcessoAcimaIdeal)
    private val contentDescriptionResultadoClassificacao:String = view.getString(R.string.contentDescriptionResultadoClassificacao)

    private val templateValorResultadoAbaixoPesoIdeal:String = view.getString(R.string.templateValorResultadoAbaixoPesoIdeal)
    private val templateValorResultadoAcimaPesoIdeal:String = view.getString(R.string.templateValorResultadoAcimaPesoIdeal)



    fun atualizarResultados(resultado: Resultado) {
       atualizarTextView(textViewResultadoPesoIdeal, formatarValor(resultado.pesoIdeal), formatarTexto(contentDescriptionResultadoPesoIdeal,formatarValor(resultado.pesoIdeal)))
       atualizarTextView(textViewResultadoPesoExcesso, formatarValorPesoExcesso(resultado.pesoExcesso), formatarPesoExcesso(resultado.pesoExcesso) )
       atualizarTextView(textViewResultadoPercentualMassaMagra, formatarValor(resultado.percentualMassaMagra), formatarTexto(contentDescriptionResultadoPercentualMassaMagra,formatarValor(resultado.percentualMassaMagra)))
       atualizarTextView(textViewResultadoPercentualGordura, formatarValor(resultado.percentualGorduraCorporal), formatarTexto(contentDescriptionResultadoPercentualGordura,formatarValor(resultado.percentualGorduraCorporal)))
       atualizarTextView(textViewResultadoMassaMagra, formatarValor(resultado.massaMagra), formatarTexto(contentDescriptionResultadoMassaMagra,formatarValor(resultado.massaMagra)))
       atualizarTextView(textViewResultadoMassaGorda, formatarValor(resultado.pesoGordo), formatarTexto(contentDescriptionResultadoMassaGorda,formatarValor(resultado.pesoGordo)))
       atualizarTextView(textViewResultadoDensidadeCorporal, formatarValor(resultado.densidadeCorporal), formatarTexto(contentDescriptionResultadoDensidadeCorporal,formatarValor(resultado.densidadeCorporal)))
       atualizarTextView(textViewResultadoClassificacao, getClassificacao(resultado.classificacao), formatarTexto(contentDescriptionResultadoClassificacao, getClassificacao(resultado.classificacao)))
   }

    private fun formatarPesoExcesso(peso: BigDecimal): String {
        val template = if (peso.signum() == -1) contentDescriptionResultadoPesoExcessoAbaixoIdeal else contentDescriptionResultadoPesoExcessoAcimaIdeal
        return formatarTexto( template, formatarValor(peso.abs()))
    }

    private fun formatarValorPesoExcesso(peso: BigDecimal): String {
        val template = if (peso.signum() == -1) templateValorResultadoAbaixoPesoIdeal else templateValorResultadoAcimaPesoIdeal
        return formatarTexto( template, formatarValor(peso.abs()))
    }

    private fun getClassificacao(classificacao: ClassificacaoPercentualGordura) =
        view.getString(ClassificacaoUtils.getResourceIdByClassificacao(classificacao))

    private fun atualizarTextView(textView: TextView,  valor: String, contentDescription: String ) {
        textView.text = valor
        textView.contentDescription = contentDescription
    }

    private fun formatarValor(valor: BigDecimal): String {
        return FormatUtils.formatarValor(valor)
    }

    private fun formatarTexto(template: String, texto: String): String {
        return MessageFormat.format(template, texto)
    }


}