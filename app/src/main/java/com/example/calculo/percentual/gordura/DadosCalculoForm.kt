package com.example.calculo.percentual.gordura

import android.view.accessibility.AccessibilityEvent
import android.widget.*
import androidx.activity.ComponentActivity
import com.example.calculo.percentual.gordura.utils.UIUtils
import com.google.android.material.textfield.TextInputLayout
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
    private val viewScroll: ScrollView = view.findViewById<ScrollView>(R.id.scrollForm)

    private val layoutViewIdade: TextInputLayout = view.findViewById<TextInputLayout>(R.id.layoutEditIdade)
    private val layoutViewPeso: TextInputLayout = view.findViewById<TextInputLayout>(R.id.layoutEditPeso)
    private val layoutViewSupra: TextInputLayout = view.findViewById<TextInputLayout>(R.id.layoutEditSupra)
    private val layoutViewTriceps: TextInputLayout = view.findViewById<TextInputLayout>(R.id.layoutEditTriceps)
    private val layoutViewAbdominal: TextInputLayout = view.findViewById<TextInputLayout>(R.id.layoutEditAbdominal)
    private val layoutViewSubescapular: TextInputLayout = view.findViewById<TextInputLayout>(R.id.layoutEditSubescapular)
    private val layoutViewCoxa: TextInputLayout = view.findViewById<TextInputLayout>(R.id.layoutEditCoxa)

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
        exibirMensagemErro(viewIdade, layoutViewIdade, mensagem)
    }

    fun exibirMensagemErroPeso(){
        val mensagem = formatarMensagem(nomeCampoPeso)
        exibirMensagemErro(viewPeso, layoutViewPeso, mensagem)
    }

    fun exibirMensagemErroSupra(){
        val mensagem = formatarMensagem(nomeCampoSupra)
        exibirMensagemErro(viewSupra, layoutViewSupra, mensagem)
    }

    fun exibirMensagemErroTriceps(){
        val mensagem = formatarMensagem(nomeCampoTriceps)
        exibirMensagemErro(viewTriceps, layoutViewTriceps, mensagem)
    }

    fun exibirMensagemErroAbdominal(){
        val mensagem = formatarMensagem(nomeCampoAbdominal)
        exibirMensagemErro(viewAbdominal, layoutViewAbdominal, mensagem)
    }

    fun exibirMensagemErroSubescapular(){
        val mensagem = formatarMensagem(nomeCampoSubscapular)
        exibirMensagemErro(viewSubescapular, layoutViewSubescapular, mensagem)
    }

    fun exibirMensagemErroCoxa(){
        val mensagem = formatarMensagem(nomeCampoCoxa)
        exibirMensagemErro(viewCoxa, layoutViewCoxa, mensagem)
    }


    private fun exibirMensagemErro(editText: EditText, textViewMessage: TextInputLayout, mensagem: String ) {
        textViewMessage.error = mensagem
        UIUtils.scrollVerticalyToElement(viewScroll, editText)
        editText.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED)
        editText.requestFocus();
    }

    private fun formatarMensagem(campo:String) : String{
        val message = view.getString(R.string.labelMessageErrorMandatory)
        return  MessageFormat.format(message, campo)
    }


}