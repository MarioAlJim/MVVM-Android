package com.wolf.bindingapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.wolf.bindingapp.databinding.ActivityMainBinding
import com.wolf.bindingapp.viewModel.GameViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val gameViewModel: GameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObservables()
        initListeners()
    }

    private fun initObservables() {
        gameViewModel.gameModel.observe(this, Observer { game ->
            binding.tvGameName.text = game.name
            binding.tvDevelopmentStudio.text = game.developmentStudio

            val gameImage: Int = resources.getIdentifier(
                game.gameImage,
                "drawable",
                packageName
            )
            binding.ivGame.setImageResource(gameImage)
        })
    }

    private fun initListeners() {
        binding.btnNewGame.setOnClickListener {
            gameViewModel.getRandomGame()
        }
    }
}