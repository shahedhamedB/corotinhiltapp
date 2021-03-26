package com.example.hiltretrofit.core

import android.content.Context
import android.content.res.Resources
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.*


const val CLICK_DELAY = 1000L

val Context.statusBarHeight: Int
    get() {
        var result = 0
        val resourceId = resources.getIdentifier(
            "status_bar_height",
            "dimen",
            "android"
        )
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

inline fun MenuItem.onClick(crossinline callback: (MenuItem) -> Unit) {
    setOnMenuItemClickListener { menu ->
        callback(menu)
        return@setOnMenuItemClickListener true
    }
}

fun View.onClick(callback: (View) -> Unit) {
    setOnClickListener(callback)
}

