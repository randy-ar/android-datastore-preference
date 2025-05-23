package edu.unikom.loginlogoutproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import edu.unikom.loginlogoutproject.databinding.ActivityLoginBinding
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val nama = binding.editNama.text.toString()
            val email = binding.editEmail.text.toString()
            val phone = binding.editPhone.text.toString()

            if(nama.isEmpty()){
                binding.editNama.error = "Nama tidak boleh kosong"
                return@setOnClickListener
            }
            if(email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.editEmail.error = "Email tidak valid"
                return@setOnClickListener
            }
            if(phone.isEmpty() || !android.util.Patterns.PHONE.matcher(phone).matches()){
                binding.editPhone.error = "Nomor HP tidak boleh kosong"
                return@setOnClickListener
            }

            lifecycleScope.launch {
                navigateToMain()
            }
        }
    }

    private fun navigateToMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}