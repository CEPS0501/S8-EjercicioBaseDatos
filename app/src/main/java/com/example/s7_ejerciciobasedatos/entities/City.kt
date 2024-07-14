package com.example.s7_ejerciciobasedatos.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities")
class City (

    @PrimaryKey(autoGenerate = true) val id:Int,
    val name:String,
    val description:String,
    val population:Int



    )