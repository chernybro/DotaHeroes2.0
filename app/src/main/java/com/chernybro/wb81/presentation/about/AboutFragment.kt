package com.chernybro.wb81.presentation.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.chernybro.wb81.R
import com.chernybro.wb81.databinding.FragmentAboutBinding
import com.chernybro.wb81.presentation.MainActivity
import com.chernybro.wb81.presentation.models.AppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.projectLinkValue.setOnClickListener {
            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.github_project_link)))
            startActivity(browserIntent)
        }
        if (PreferenceManager.getDefaultSharedPreferences(context)
                .getString(MainActivity.KEY_APP_THEME, AppTheme.DEFAULT.name) == AppTheme.DEFAULT.name) {
            binding.defaultThemeButton.isChecked = true
            binding.blueYellowThemeButton.isChecked = false
        } else {
            binding.blueYellowThemeButton.isChecked = true
            binding.defaultThemeButton.isChecked = false
        }

        binding.defaultThemeButton.setOnClickListener {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(MainActivity.KEY_APP_THEME, AppTheme.DEFAULT.name).commit()
            (activity as MainActivity).recreate()
        }

        binding.blueYellowThemeButton.setOnClickListener {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(MainActivity.KEY_APP_THEME, AppTheme.BLUE.name).commit()
            (activity as MainActivity).recreate()
        }

        binding.toolbar.setNavigationOnClickListener { (activity as MainActivity).onBackPressed() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}