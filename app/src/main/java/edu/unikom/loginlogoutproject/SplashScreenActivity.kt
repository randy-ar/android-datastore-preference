package edu.unikom.loginlogoutproject

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import edu.unikom.loginlogoutproject.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fungsi Slide Animation
        val slideIn = AnimationUtils.loadAnimation(this, R.anim.slide_in)
        binding.textLoading.startAnimation(slideIn)
        binding.textNamaAplikasi.startAnimation(slideIn)

        lifecycleScope
            .launch {
                delay(2000)
                startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
                finish()
            }
    }
}