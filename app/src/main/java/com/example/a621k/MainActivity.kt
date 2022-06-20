package com.example.a621k

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Boolean


class MainActivity : AppCompatActivity() {
    lateinit var et_string: EditText
    lateinit var et_float: EditText
    lateinit var et_integer: EditText
    lateinit var _switch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        save()
    }

    private fun init() {
        et_string = findViewById(R.id.et_string)
        et_integer = findViewById(R.id.et_integer)
        et_float = findViewById(R.id.et_float)
        _switch = findViewById(R.id._switch)
    }

    fun save() {
        val save = findViewById<Button>(R.id.save)
        save.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putLong("long", et_string.text.toString().toLong())
            editor.putInt("int", et_integer.text.toString().toInt())
            editor.putFloat("float", et_float.text.toString().toFloat())
            editor.putBoolean("boolean", _switch.isChecked)
            editor.apply()
            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
        }
    }
}