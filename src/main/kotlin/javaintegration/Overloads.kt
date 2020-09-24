package javaintegration

import java.text.NumberFormat

data class Product @JvmOverloads constructor(

    val name: String,
    val price: Double = 0.0,
    val desc: String? = null
){
    val firstProperty = "First property: $name".also(::println)
    init {
        println("First initializer block that prints $name")
    }
}

@JvmOverloads
fun addProduct(name: String, price: Double = 0.0, desc: String? = null) =
    "Adding product with $name, ${desc ?: "None"}, and " +
            NumberFormat.getCurrencyInstance().format(price)
