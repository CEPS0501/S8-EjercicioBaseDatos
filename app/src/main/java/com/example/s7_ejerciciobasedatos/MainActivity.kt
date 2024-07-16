package com.example.s7_ejerciciobasedatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.s7_ejerciciobasedatos.dao.DatabaseBuilder
import com.example.s7_ejerciciobasedatos.databinding.ActivityMainBinding
import com.example.s7_ejerciciobasedatos.entities.City
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}