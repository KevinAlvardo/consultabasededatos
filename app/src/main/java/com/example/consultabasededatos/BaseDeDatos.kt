// BaseDeDatos.kt
package com.example.consultabasededatos

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Clase que gestiona la base de datos SQLite
class BaseDeDatos(context: Context) : SQLiteOpenHelper(context, NOMBRE_BD, null, BD_VERSION) {

    companion object {
        private const val NOMBRE_BD = "mensaje.db"
        private const val BD_VERSION = 1
        private const val NOMBRE_TABLA = "mensaje"
        private const val ID = "id"
        private const val MENSAJE = "mensaje"
    }

    // Método llamado cuando se crea la base de datos por primera vez
    override fun onCreate(db: SQLiteDatabase?) {
        // Crear la tabla con un campo para el ID autoincremental y un campo para el mensaje
        val queryCrearTabla = "CREATE TABLE $NOMBRE_TABLA($ID INTEGER PRIMARY KEY AUTOINCREMENT, $MENSAJE TEXT)"
        db?.execSQL(queryCrearTabla)
    }

    // Método llamado cuando se necesita actualizar la base de datos
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Eliminar la tabla existente si hay una versión anterior y crear una nueva
        val queryBorrarTabla = "DROP TABLE IF EXISTS $NOMBRE_TABLA"
        db?.execSQL(queryBorrarTabla)
        onCreate(db)
    }

    // Método para insertar un nuevo mensaje en la base de datos
    fun insertarMensaje(registro: Registro) {
        val base_de_datos = writableDatabase
        val valores = ContentValues().apply {
            put(MENSAJE, registro.mensaje)
        }
        base_de_datos.insert(NOMBRE_TABLA, null, valores)
        base_de_datos.close()
    }
}
