package com.example.exercise_retrofit.artist

class Artist(var id: String = ""
             , var name: String = ""
             , var bornPlace: String = ""
             , var debut: String = "")
//             , var username: String = ""
//             , var email: String = ""
//             , var address: Address)

data class Address(var street: String = ""
                   , var suite: String = ""
                   , var city: String = ""
                   , var zipcode: String = "")