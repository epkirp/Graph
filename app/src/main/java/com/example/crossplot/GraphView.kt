package com.example.crossplot

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.crossplot.models.Point

interface GraphView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setNewPoint(point: Point)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun startAcceptButton()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun pauseAcceptButton()
}