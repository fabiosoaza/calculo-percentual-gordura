package com.example.calculo.percentual.gordura

import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.text.MessageFormat

class DadosCalculoForm(private var view: ComponentActivity) {

    private val radioGroupSexo: RadioGroup = view.findViewById<RadioGroup>(R.id.radioGoupSexo)
    private val viewSexo:  RadioButton = view.findViewById<RadioButton>(radioGroupSexo.checkedRadioButtonId)

    private val viewIdade: EditText = view.findViewById<EditText>(R.id.editIdade)
    private val viewPeso: EditText = view.findViewById<EditText>(R.id.editPeso)
    private val viewSupra: EditText = view.findViewById<EditText>(R.id.editSupra)
    private val viewTriceps: EditText = view.findViewById<EditText>(R.id.editTriceps)
    private val viewAbdominal: EditText = view.findViewById<EditText>(R.id.editAbdominal)
    private val viewSubescapular: EditText = view.findViewById<EditText>(R.id.editSubescapular)
    private val viewCoxa: EditText = view.findViewById<EditText>(R.id.editCoxa)

    private val textViewMensagem: TextView = view.findViewById<TextView>(R.id.textViewMessageError)
    private val nomeCampoIdade = view.getString(R.string.labelIdade)
    private val nomeCampoPeso = view.getString(R.string.labelPeso)
    private val nomeCampoSupra = view.getString(R.string.labelSupraIliaca)
    private val nomeCampoTriceps = view.getString(R.string.labelTriceps)
    private val nomeCampoAbdominal = view.getString(R.string.labelAbnominal)
    private val nomeCampoSubscapular = view.getString(R.string.labelSubescapular)
    private val nomeCampoCoxa = view.getString(R.string.labelCoxa)


    val idade: String
        get() = viewIdade.text.toString()

    val peso: String
        get() = viewPeso.text.toString()

    val supra: String
        get() = viewSupra.text.toString()

    val triceps: String
        get() = viewTriceps.text.toString()

    val abdominal: String
        get() = viewAbdominal.text.toString()

    val subescapular: String
        get() = viewSubescapular.text.toString()

    val coxa: String
        get() = viewCoxa.text.toString()

    fun isSexoMasculino(): Boolean {
        return view.getString(R.string.labelSexoMasculino) == viewSexo.text.toString()
    }

    fun exibirMensagemErroIdade(){
        val mensagem = formatarMensagem(nomeCampoIdade)
        exibirMensagemErro(viewIdade, textViewMensagem, mensagem)
    }

    fun exibirMensagemErroPeso(){
        val mensagem = formatarMensagem(nomeCampoPeso)
        exibirMensagemErro(viewPeso, textViewMensagem, mensagem)
    }

    fun exibirMensagemErroSupra(){
        val mensagem = formatarMensagem(nomeCampoSupra)
        exibirMensagemErro(viewSupra, textViewMensagem, mensagem)
    }

    fun exibirMensagemErroTriceps(){
        val mensagem = formatarMensagem(nomeCampoTriceps)
        exibirMensagemErro(viewTriceps, textViewMensagem, mensagem)
    }

    fun exibirMensagemErroAbdominal(){
        val mensagem = formatarMensagem(nomeCampoAbdominal)
        exibirMensagemErro(viewAbdominal, textViewMensagem, mensagem)
    }

    fun exibirMensagemErroSubescapular(){
        val mensagem = formatarMensagem(nomeCampoSubscapular)
        exibirMensagemErro(viewSubescapular, textViewMensagem, mensagem)
    }

    fun exibirMensagemErroCoxa(){
        val mensagem = formatarMensagem(nomeCampoCoxa)
        exibirMensagemErro(viewCoxa, textViewMensagem, mensagem)
    }

    fun limparMensagemErro() {
        limparMensagemErro(this.textViewMensagem)

    }

    private fun exibirMensagemErro(editText: EditText, textViewMessage: TextView, mensagem: String ) {
        textViewMessage.text = mensagem
        textViewMessage.visibility = View.VISIBLE
        editText.requestFocus();
    }


    private fun limparMensagemErro(textViewMessage:TextView){
        textViewMessage.visibility = View.INVISIBLE
        textViewMessage.text = ""
    }

    private fun formatarMensagem(campo:String) : String{
        val message = view.getString(R.string.labelMessageErrorMandatory)
        return  MessageFormat.format(message, campo)
    }


}