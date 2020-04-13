package com.example.calculo.percentual.gordura

import android.view.View
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.not
import org.hamcrest.TypeSafeMatcher


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
            element.perform(ViewActions.scrollTo())
            verificarElementoEstaSendoExibido(element)
            element.perform(ViewActions.closeSoftKeyboard(), ViewActions.click())
        }

        fun verificarTextoElemento(elementId: Int, texto: String) {
            val element = findElementById(elementId)
            verificarElementoEstaSendoExibido(element)
            element.check(matches(withText(texto)))
        }

        fun verificarErroTexto(elementId: Int, texto: String) {
            val element = findElementById(elementId)
            verificarElementoEstaSendoExibido(element)
            element.check(matches(hasTextInputLayoutErrorText(texto)))
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

        /**
         * Custom matcher para as mensagens de erro dos text input layout
         * */
        private fun hasTextInputLayoutErrorText(expectedErrorText: String): Matcher<View> {
            return object : TypeSafeMatcher<View>() {
                override fun matchesSafely(view: View): Boolean {
                    if (view !is TextInputLayout) {
                        return false
                    }
                    val error = (view as TextInputLayout).error ?: return false
                    val hint = error.toString()
                    return expectedErrorText == hint
                }

                override fun describeTo(description: Description?) {}
            }
        }



    }





}