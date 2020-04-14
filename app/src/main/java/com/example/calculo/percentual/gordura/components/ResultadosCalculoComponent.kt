package com.example.calculo.percentual.gordura.components

import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.calculo.percentual.gordura.R
import com.example.calculo.percentual.gordura.calculadora.ClassificacaoPercentualGordura
import com.example.calculo.percentual.gordura.calculadora.ResultadoCalculo
import com.example.calculo.percentual.gordura.utils.ClassificacaoUtils
import com.example.calculo.percentual.gordura.utils.FormatadorUtils
import java.math.BigDecimal
import java.text.MessageFormat

class ResultadosCalculoComponent(private var view: ComponentActivity) {

    private val textViewResultadoDensidadeCorporal: TextView = view.findViewById<TextView>(
        R.id.textViewResultadoDensidadeCorporal
    )
    private val textViewResultadoMassaGorda: TextView = view.findViewById<TextView>(
        R.id.textViewResultadoMassaGorda
    )
    private val textViewResultadoMassaMagra: TextView = view.findViewById<TextView>(
        R.id.textViewResultadoMassaMagra
    )
    private val textViewResultadoPercentualGordura: TextView = view.findViewById<TextView>(
        R.id.textViewResultadoPercentualGordura
    )
    private val textViewResultadoPercentualMassaMagra: TextView = view.findViewById<TextView>(
        R.id.textViewResultadoPercentualMassaMagra
    )
    private val textViewResultadoPesoIdeal: TextView = view.findViewById<TextView>(
        R.id.textViewResultadoPesoIdeal
    )
    private val textViewResultadoPesoExcesso: TextView = view.findViewById<TextView>(
        R.id.textViewResultadoPesoExcesso
    )
    private val textViewResultadoClassificacao: TextView = view.findViewById<TextView>(
        R.id.textViewResultadoClassificacao
    )

    private val contentDescriptionResultadoDensidadeCorporal:String = view.getString(
        R.string.contentDescriptionResultadoDensidadeCorporal
    )
    private val contentDescriptionResultadoMassaGorda:String = view.getString(R.string.contentDescriptionResultadoMassaGorda)
    private val contentDescriptionResultadoMassaMagra:String = view.getString(R.string.contentDescriptionResultadoMassaMagra)
    private val contentDescriptionResultadoPercentualGordura:String = view.getString(
        R.string.contentDescriptionResultadoPercentualGordura
    )
    private val contentDescriptionResultadoPercentualMassaMagra:String = view.getString(
        R.string.contentDescriptionResultadoPercentualMassaMagra
    )
    private val contentDescriptionResultadoPesoIdeal:String = view.getString(R.string.contentDescriptionResultadoPesoIdeal)
    private val contentDescriptionResultadoPesoExcessoAbaixoIdeal:String = view.getString(
        R.string.contentDescriptionResultadoPesoExcessoAbaixoIdeal
    )
    private val contentDescriptionResultadoPesoExcessoAcimaIdeal:String = view.getString(
        R.string.contentDescriptionResultadoPesoExcessoAcimaIdeal
    )
    private val contentDescriptionResultadoClassificacao:String = view.getString(R.string.contentDescriptionResultadoClassificacao)

    private val templateValorResultadoAbaixoPesoIdeal:String = view.getString(R.string.templateValorResultadoAbaixoPesoIdeal)
    private val templateValorResultadoAcimaPesoIdeal:String = view.getString(R.string.templateValorResultadoAcimaPesoIdeal)



    fun atualizarResultados(resultadoCalculo: ResultadoCalculo) {
       atualizarTextView(textViewResultadoPesoIdeal, formatarValor(resultadoCalculo.pesoIdeal), formatarTexto(contentDescriptionResultadoPesoIdeal,formatarValor(resultadoCalculo.pesoIdeal)))
       atualizarTextView(textViewResultadoPesoExcesso, formatarValorPesoExcesso(resultadoCalculo.pesoExcesso), formatarPesoExcesso(resultadoCalculo.pesoExcesso) )
       atualizarTextView(textViewResultadoPercentualMassaMagra, formatarValor(resultadoCalculo.percentualMassaMagra), formatarTexto(contentDescriptionResultadoPercentualMassaMagra,formatarValor(resultadoCalculo.percentualMassaMagra)))
       atualizarTextView(textViewResultadoPercentualGordura, formatarValor(resultadoCalculo.percentualGorduraCorporal), formatarTexto(contentDescriptionResultadoPercentualGordura,formatarValor(resultadoCalculo.percentualGorduraCorporal)))
       atualizarTextView(textViewResultadoMassaMagra, formatarValor(resultadoCalculo.massaMagra), formatarTexto(contentDescriptionResultadoMassaMagra,formatarValor(resultadoCalculo.massaMagra)))
       atualizarTextView(textViewResultadoMassaGorda, formatarValor(resultadoCalculo.pesoGordo), formatarTexto(contentDescriptionResultadoMassaGorda,formatarValor(resultadoCalculo.pesoGordo)))
       atualizarTextView(textViewResultadoDensidadeCorporal, formatarValor(resultadoCalculo.densidadeCorporal), formatarTexto(contentDescriptionResultadoDensidadeCorporal,formatarValor(resultadoCalculo.densidadeCorporal)))
       atualizarTextView(textViewResultadoClassificacao, getClassificacao(resultadoCalculo.classificacao), formatarTexto(contentDescriptionResultadoClassificacao, getClassificacao(resultadoCalculo.classificacao)))
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
        return FormatadorUtils.formatarValor(valor)
    }

    private fun formatarTexto(template: String, texto: String): String {
        return MessageFormat.format(template, texto)
    }


}