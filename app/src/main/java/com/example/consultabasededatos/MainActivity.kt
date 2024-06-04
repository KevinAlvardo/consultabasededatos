// MainActivity.kt
package com.example.consultabasededatos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.consultabasededatos.databinding.ActivityMainBinding

// Actividad principal de la aplicación
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Manejar el clic en el botón "Nuevo Registro"
        binding.btnNuevoRegistro.setOnClickListener{
            // Iniciar la actividad Guardar para permitir al usuario guardar un nuevo mensaje
            val intent= Intent(this, Guardar::class.java)
            startActivity(intent)
        }
    }
}
