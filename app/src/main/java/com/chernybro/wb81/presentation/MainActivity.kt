package com.chernybro.wb81.presentation


import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import com.chernybro.wb81.R
import com.chernybro.wb81.databinding.ActivityMainBinding
import com.chernybro.wb81.presentation.hero_list_screen.HeroesListFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (supportFragmentManager.backStackEntryCount == 0) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment, HeroesListFragment())
                .commit()
        }
    }


    fun addFragmentOnTop(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment, fragment)
            .addToBackStack(null)
            .commit()
    }

}