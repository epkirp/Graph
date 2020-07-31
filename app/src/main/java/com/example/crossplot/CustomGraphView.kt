package com.example.crossplot

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.crossplot.models.Point

class CustomGraphView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var points: ArrayList<Point>? = null
    private val shift = 30f
    private val scale = 128f
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private fun drawPoint(point: Point, canvas: Canvas) {
        paint.style = Paint.Style.FILL
        paint.color = point.color
        canvas.drawCircle((point.x), (point.y), point.radius, paint)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawAxis(canvas)
        drawPoints(canvas)
    }

    fun setNewPoint(point: Point) {
        if (points == null) {
            points = ArrayList()
        }
        points!!.add(point)
    }

    private fun drawPoints(canvas: Canvas) {
        paint.style = Paint.Style.STROKE
        paint.color = Color.RED

        if (!points.isNullOrEmpty()) {
            for (i in 0..points!!.size - 2) {
                canvas.drawLine(
                    //(points!![i].x + shift) * scale,
                    //(points!![i].y + shift) * scale,
                    //(points!![i + 1].x + shift) * scale,
                    //(points!![i + 1].y + shift) * scale,
                    (points!![i].x),
                    (points!![i].y),
                    (points!![i + 1].x),
                    (points!![i + 1].y),
                    paint
                )
            }
        }

        points?.forEach {
            drawPoint(it, canvas)
        }
    }

    private fun drawAxis(canvas: Canvas) {
        paint.style = Paint.Style.FILL
        paint.color = Color.LTGRAY
        paint.strokeWidth = 6f

        canvas.drawLine(shift, shift, shift, height.toFloat() - shift, paint)
        canvas.drawLine(shift, height - shift, width - shift, height - shift, paint)

        var i = 0f
        while (i * scale < height - shift) {
            i += 1f
            canvas.drawLine(
                shift - shift / 2f,
                scale * i,
                shift + shift / 2f,
                scale * i,
                paint
            )
        }

        i = 0f
        while (i * scale < width - shift) {
            i += 1f
            canvas.drawLine(
                scale * i,
                height - shift - shift / 2f,
                scale * i,
                height - shift / 2f,
                paint
            )
        }
    }
}