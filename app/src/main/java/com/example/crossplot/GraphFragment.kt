package com.example.crossplot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.crossplot.models.Point
import kotlinx.android.synthetic.main.fragment_graph.*

class GraphFragment : MvpAppCompatFragment(), GraphView {

    @InjectPresenter
    lateinit var presenter: GraphPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_graph, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.step = 12
        presenter.time = 2
        presenter.changeAcceptButtonState()

        acceptButton.setOnClickListener {
            presenter.changeAcceptButtonState()
            presenter.setPoint()
        }
    }

    override fun setNewPoint(point: Point) {
        customGraphView.setNewPoint(point)
        customGraphView.invalidate()

        customGraphView.refreshDrawableState()
    }

    override fun startAcceptButton() {
        acceptButton.text = getString(R.string.start)
    }

    override fun pauseAcceptButton() {
        acceptButton.text = getString(R.string.pause)
    }
}