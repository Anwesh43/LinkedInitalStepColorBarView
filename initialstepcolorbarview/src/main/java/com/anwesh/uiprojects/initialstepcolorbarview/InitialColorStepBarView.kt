package com.anwesh.uiprojects.initialstepcolorbarview

/**
 * Created by anweshmishra on 04/06/20.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF

val bars : Int = 5
val scGap : Float = 0.02f / bars
val colors : Array<String> = arrayOf("#3F51B5", "#4CAF50", "#2196F3", "#F44336", "#009688")
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawColorStepBar(i : Int, scale : Float, w : Float, h : Float, paint : Paint) {
    val size : Float = w / (bars)
    val sf : Float = scale.sinify()
    val sf1 : Float = sf.divideScale(0, 2)
    val sf2 : Float = sf.divideScale(1, 2)
    val sf1i : Float = sf1.divideScale(i, bars)
    val sf2i : Float = sf2.divideScale(i, bars)
    save()
    translate(size * i, h * sf2i)
    drawRect(RectF(0f, 0f, size * sf1i, size), paint)
    restore()
}

fun Canvas.drawICSBNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = Color.parseColor(colors[i])
    save()
    for (j in 0..(bars - 1)) {
        drawColorStepBar(i, scale, w, h, paint)
    }
    restore()
}

