package com.example.mymarketmobileversion

import java.net.URL

class Product {
    var name = ""
    var description = ""
    var price = ""
    var url = ""
    constructor(name:String, description:String, price:String, url: String){
        this.name = name
        this.description = description
        this.price = price
        this.url = url
    }
}