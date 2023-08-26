package com.example.core.extension

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

fun EditText.onChange(callBack: (String) -> Unit) {
    this.addTextChangedListener(
        object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!isEnabled)
                    return
                callBack(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        }
    )
}
