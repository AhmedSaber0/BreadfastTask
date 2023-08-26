package com.example.core.base.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    lateinit var binding: VB
        private set

    lateinit var navController: NavController
        private set

    @get:StyleRes
    protected abstract val activityTheme: Int

    @get:NavigationRes
    abstract val graph: Int

    @get:IdRes
    abstract val navHostId: Int

    abstract fun onCreateBinding(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(activityTheme)

        super.onCreate(savedInstanceState)

        binding = onCreateBinding(layoutInflater)
        setContentView(binding.root)

        val host = supportFragmentManager.findFragmentById(navHostId) as NavHostFragment
        navController = host.navController
    }
}
