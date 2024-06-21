package com.example.homeworkout.data

data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    var imagePath: String = ""
)
{
    constructor() :this("","","","")
}
