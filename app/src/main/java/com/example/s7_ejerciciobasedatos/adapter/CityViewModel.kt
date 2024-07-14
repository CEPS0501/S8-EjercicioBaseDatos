package com.example.s7_ejerciciobasedatos.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.s7_ejerciciobasedatos.dao.CityDao
import com.example.s7_ejerciciobasedatos.entities.City

class CityViewModel(private val cityDao: CityDao):ViewModel() {
    val allCities : LiveData<List<City>> = cityDao.getAllCities()
}

class CityViewModelFactory(private val cityDao: CityDao): ViewModelProvider.Factory{
    override fun <T: ViewModel> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(CityViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return CityViewModel(cityDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}