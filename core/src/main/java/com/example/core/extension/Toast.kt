package com.example.core.extension

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun showToast(context: Context, textString: String) {
    Toast.makeText(context, textString, Toast.LENGTH_SHORT).show()
}
fun showToast(context: Context, @StringRes textString: Int) {
    Toast.makeText(context, textString, Toast.LENGTH_SHORT).show()
}
