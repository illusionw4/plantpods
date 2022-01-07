package com.example.plantpods.Model

data class Plantmodel (
    val image: String?="",
    val plantname: String?="",
    val description: String?=""
){
    constructor():this("","","")
}
