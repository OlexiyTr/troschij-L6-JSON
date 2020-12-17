package com.example.exework

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

fun main(){
    val gson = Gson()
    val mom : Person_ = Person_("Лариса", 51, true,4,null,null)
    val dad : Person_ = Person_("Батько", 53, true,4,null,null)
    val dataToJSON = gson.toJson(Person_("Олекксій",20,true,6,mom,dad))
    println("${dataToJSON}\n")

    val jsonString = """{"Name": "Михайло",
                  "age":"30",
                  "adulthood":true,
                  "numberOfRelatives":"6",
                  "Mother":{"Name": "Наташа",
                  "age":"50",
                  "adulthood":true,
                  "numberOfRelatives":"4",
                  "Mother":null,
                    "Father":null},
                    "Father":null}"""
    val dataFromJSON: Person_ =gson.fromJson(jsonString, Person_::class.java)
    println(dataFromJSON.toString())

    val jsonString2 = """{"Name": "Лера",
                  "age":"15",
                  "adulthood":false,
                  "numberOfRelatives":"6",
                  "Mother":{"Name": "Марина",
                  "age":"38",
                  "adulthood":true,
                  "numberOfRelatives":"2",
                  "Mother":null,
                    "Father":null},
                    "Father":{"Name": "Саша",
                  "age":"40",
                  "adulthood":true,
                  "numberOfRelatives":"2",
                  "Mother":null,
                    "Father":null}}"""
    val dataFromJSON2: Person_ =gson.fromJson(jsonString2, Person_::class.java)
    println(dataFromJSON2.toString())
}

data class Person_(
    @SerializedName("Name")val name: String,
    val age: Int,
    val adulthood: Boolean,
    val numberOfRelatives: Int,
    @SerializedName("Mother") val mother : Person_?,
    @SerializedName("Father") val father : Person_?
)