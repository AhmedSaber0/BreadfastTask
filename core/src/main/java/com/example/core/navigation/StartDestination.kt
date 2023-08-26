package com.example.core.navigation

import android.os.Bundle
import androidx.annotation.IdRes

data class StartDestination(
    @IdRes val destination: Int,
    val args: Bundle? = null
)
