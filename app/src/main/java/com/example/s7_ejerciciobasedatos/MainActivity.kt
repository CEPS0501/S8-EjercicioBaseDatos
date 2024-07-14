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
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        funMain()

    }

    private fun funMain() = runBlocking{
        val context = this@MainActivity
        val db = DatabaseBuilder.getInstance(context)

        val city1 = City(0, "Masaya", "Ciudad de las flores", 5000)
        val city2 = City(0, "Managua", "Capital de Nicaragua", 500600)
        val city3 = City(0, "Granada", "La Gran Sultana", 200600)

        var listCities : List<City> = listOf(city1, city2, city3)

        val cityDao = db.cityDAO()

        listCities.forEach{city ->
            cityDao.insert(city)
        }

    }

}