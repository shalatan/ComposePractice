package com.example.composepractice.codelab.statedemo

class WellnessTestList {

    fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
}