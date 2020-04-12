package com.example.calculo.percentual.gordura

import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers
import org.hamcrest.Matchers.not

class ExpressoElementUtils {

    companion object {
        fun findElementById(elementId: Int): ViewInteraction {
            val element = Espresso.onView(
                Matchers.allOf(
                    ViewMatchers.withId(elementId)
                )
            )
            return element
        }

        fun preencherEditText(elementId: Int, valor: String) {
            val element = findElementById(elementId)
            verificarElementoEstaSendoExibido(element)
            element.perform(ViewActions.replaceText(valor), ViewActions.closeSoftKeyboard())
        }

        fun marcarRadio(elementId: Int) {
            val element = findElementById(elementId)
            verificarElementoEstaSendoExibido(element)
            element.perform(ViewActions.click())
        }

        fun clicarBotao(elementId: Int) {
            val element = findElementById(elementId)
            verificarElementoEstaSendoExibido(element)
            element.perform(ViewActions.click())
        }

        fun verificarTextoElemento(elementId: Int, texto: String) {
            val element = findElementById(elementId)
            verificarElementoEstaSendoExibido(element)
            element.check(matches(withText(texto)))
        }

        fun verificarElementoEstaSendoExibido(elementId:Int) {
            verificarElementoEstaSendoExibido( findElementById(elementId))
        }

        fun verificarElementoNaoExiste(elementId:Int) {
            try {
                val element = findElementById(elementId)
                element.check(matches(not(ViewMatchers.isDisplayed())))
            }
            catch(ex: NoMatchingViewException){

            }
        }

        public fun getString(stringElementId: Int): String {
            return InstrumentationRegistry.getTargetContext().getString(stringElementId)
        }

        private fun verificarElementoEstaSendoExibido(element:ViewInteraction) {
            element.check(matches(ViewMatchers.isDisplayed()))
        }



    }

}