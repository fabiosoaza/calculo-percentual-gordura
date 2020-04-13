package com.example.calculo.percentual.gordura.utils

import android.view.View
import android.widget.ScrollView

class UIUtils {
    companion object {
        fun scrollVerticalyToElement(scrollView:ScrollView, viewToScrollTo: View){
            scrollView.post(Runnable {
                val vTop: Int = viewToScrollTo.top
                val vBottom: Int = viewToScrollTo.bottom
                val sHeight: Int = scrollView.height
                val position: Int = ((vTop + vBottom - sHeight) / 2)
                scrollView.smoothScrollTo(0, position)
            })
        }
    }
}