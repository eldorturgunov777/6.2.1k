package com.example.a621k

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.a621k.manager.PrefsManager
import java.lang.Boolean


class MainActivity : AppCompatActivity() {
    lateinit var et_string: EditText
    lateinit var et_float: EditText
    lateinit var et_boolean: EditText
    lateinit var et_integer: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        et_string = findViewById(R.id.et_string)
        et_float = findViewById(R.id.et_float)
        et_boolean = findViewById(R.id.et_boolean)
        et_integer = findViewById(R.id.et_integer)

    }

    fun save(view: View) {
        val name = et_string.text.toString()
        val number = et_integer.text.toString().toInt()
        val floatD = et_float.text.toString().toFloat()
        val booleanD = Boolean.parseBoolean(et_boolean.text.toString())

        PrefsManager.getInstance(this)!!.saveStringData("name", name)
        PrefsManager.getInstance(this)!!.saveIntData("number", number)
        PrefsManager.getInstance(this)!!.saveFloatData("float", floatD)
        PrefsManager.getInstance(this)!!.saveBooleanData("boolean", booleanD)
    }

}