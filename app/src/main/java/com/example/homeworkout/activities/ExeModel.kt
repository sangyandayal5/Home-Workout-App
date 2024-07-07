package com.example.homeworkout.activities

class ExeModel(
    private var exeName : String,
    private var imgSrc : Int,
    private var imgSrc1 : Int
) {
    fun getName() : String{
        return exeName
    }
    fun getImg() : Int{
        return imgSrc
    }

    fun getImg1() : Int{
        return imgSrc1
    }
}