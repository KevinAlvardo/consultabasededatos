// Guardar.kt
package com.example.consultabasededatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.consultabasededatos.databinding.ActivityGuardarBinding

// Actividad para guardar un mensaje en la base de datos
class Guardar : AppCompatActivity() {

    private lateinit var binding: ActivityGuardarBinding
    private lateinit var db: BaseDeDatos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuardarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar la instancia de la base de datos
        db = BaseDeDatos(this)

        // Manejar el clic en el botón "Guardar"
        binding.btnGuardar.setOnClickListener {
            // Obtener el mensaje del campo de texto
            val mensaje = binding.txtData.text.toString()
            // Crear un objeto Registro con el mensaje
            val registro = Registro(mensaje)
            // Insertar el registro en la base de datos
            db.insertarMensaje(registro)
            // Cerrar la actividad
            finish()
            // Mostrar un mensaje de confirmación
            Toast.makeText(this, "¡Se ha guardado el mensaje!", Toast.LENGTH_LONG).show()
        }
    }
}
