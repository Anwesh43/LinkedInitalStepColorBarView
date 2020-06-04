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

