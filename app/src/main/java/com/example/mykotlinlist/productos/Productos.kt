package com.example.mykotlinlist.productos

//anotacion para los getters y setters
data class Productos (
    val nombreDeProducto:String,
    val categoriaDeProducto:String,
    val supermercado:String,
    val precio:String,

){
    override fun toString(): String {
        return "NombreDeProducto='$nombreDeProducto' categoriaDeProducto='$categoriaDeProducto'  precio='$precio'\n"
    }
}