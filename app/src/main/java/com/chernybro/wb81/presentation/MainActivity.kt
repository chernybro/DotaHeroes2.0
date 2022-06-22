package com.chernybro.wb81.presentation


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.chernybro.wb81.R
import com.chernybro.wb81.databinding.ActivityMainBinding
import com.chernybro.wb81.presentation.hero_list_screen.HeroesListFragment
import com.chernybro.wb81.presentation.models.AppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val KEY_APP_THEME = "KEY_APP_THEME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setTheme()
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

    private fun setTheme() {
        Log.d("APP_TAG", "setTheme: ${PreferenceManager.getDefaultSharedPreferences(applicationContext).getString(KEY_APP_THEME, AppTheme.DEFAULT.name)} ")
        when (PreferenceManager.getDefaultSharedPreferences(applicationContext).getString(
            KEY_APP_THEME, AppTheme.DEFAULT.name)) {
            AppTheme.DEFAULT.name -> setTheme(R.style.Theme_WB51)
            AppTheme.BLUE.name -> setTheme(R.style.Base_Theme_WB51_Blue)
        }
    }

}