package com.example.consultabasededatos
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDeDatos(context : Context) : SQLiteOpenHelper(context, NOMBRE_BD,null, BD_VERSION) {

    companion object {

        private const val  NOMBRE_BD = "mensaje.db"
        private const val  BD_VERSION = 1
        private const val NOMBRE_TABLA = "mensaje"
        private const val ID = "id"
        private const val MENSAJE = "mensaje"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val queryCrearTabla = "CREATE TABLE $NOMBRE_TABLA($ID INTEGER PRIMARY KEY AUTOINCREMENT, $MENSAJE TEXT)"
        db?.execSQL(queryCrearTabla)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val queryBorrarTabla = "DROP TABLE IF EXISTS $NOMBRE_TABLA"
        db?.execSQL(queryBorrarTabla)
        onCreate(db)
    }

    fun insertarMensaje(registro : Registro){
        val base_de_datos = writableDatabase
        val valores = ContentValues().apply {
            put(MENSAJE, registro.mensaje)
        }
        base_de_datos.insert(NOMBRE_BD,null,valores)
        base_de_datos.close()
    }

}