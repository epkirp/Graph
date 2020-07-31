package com.example.crossplot

import android.graphics.Color
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.crossplot.models.Point

@InjectViewState
class GraphPresenter : MvpPresenter<GraphView>() {
    var step: Int? = null
    var time: Int? = null
    var i: Int = 0

    private var buttonStart = true

    fun setPoint() {
        viewState.setNewPoint(
            Point(
                (step!! * ++i).toFloat(),
                (10..720).random().toFloat(),
                8f,
                Color.GREEN
            )
        )
    }

    fun changeAcceptButtonState() {
        if (buttonStart) {
            viewState.startAcceptButton()
        } else {
            viewState.pauseAcceptButton()
        }
        buttonStart = !buttonStart
    }



}