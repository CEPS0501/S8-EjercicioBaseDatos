package com.example.s7_ejerciciobasedatos.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.s7_ejerciciobasedatos.entities.City

@Database(entities = [City::class], version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun cityDAO():CityDao



}