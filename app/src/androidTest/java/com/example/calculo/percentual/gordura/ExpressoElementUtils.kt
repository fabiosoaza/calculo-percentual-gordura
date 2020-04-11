package com.example.calculo.percentual.gordura

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers

class ExpressoElementUtils {

    companion object {
        fun findEditById(elementId: Int): ViewInteraction {
            val element = Espresso.onView(
                Matchers.allOf(
                    ViewMatchers.withId(elementId),
                    ViewMatchers.isDisplayed()
                )
            )
            return element
        }

        fun preencherEditText(elementId: Int, valor: String) {
            val element = findEditById(elementId)
            element.perform(ViewActions.replaceText(valor), ViewActions.closeSoftKeyboard())
        }

        fun marcarRadio(elementId: Int) {
            val element = findEditById(elementId)
            element.perform(ViewActions.click())
        }

        fun clicarBotao(elementId: Int) {
            val element = findEditById(elementId)
            element.perform(ViewActions.click())
        }

        fun verificarTextoElemento(elementId: Int, texto: String) {
            val element = findEditById(elementId)
            element.check(matches(withText(texto)))
        }

    }

}