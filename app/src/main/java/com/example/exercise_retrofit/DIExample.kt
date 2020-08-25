package com.example.exercise_retrofit

fun main() {
    var mesinBensinku: GasolineEngine = GasolineEngine()
    var mesinListrikKu = ElectricEngine()

//    var mobilBensinku: Car = Car(mesinBensinku)
//    var mobilListrikKu = Car(mesinListrikKu)

    var mobilBensinku: Car = Car(mesinBensinku)
    mobilBensinku.startEngine()
    // setter injection
    // kalau engine nya dalam bentuk interface atau abstract class
    var mobilListrikKu = Car()
    mobilListrikKu.engine = mesinBensinku
    mobilListrikKu.startEngine()

}

// dependency injection: Constructor Injection
// tidak akan batasan solusi hanya menggunakan Inheritance
// direkomendasikan menggunakan solusi interface atau abstract class biar lebih ketat aturannya
// biar ngga ada developer yg ngga sengaja assign class engine

// DI: Constructor Injection, Setter Injection
// Setter injection diset null : menambah fleksibilitas dengan tidak menginstiate object
// var engine: Engine? = null
class Car(var engine: Engine? = null) {
    // ngga boleh kaya gini karena ngga fleksible
    // kalau engine ditaruh disini jadi ngga fleksible
    // var engine = Engine()

    fun startEngine() {
        engine?.start()
    }

}

// ini inheritance class : open class
// bisa pake abstract class (constructor)
// atau pake interface
interface Engine {
    fun start() {
//        println("Mesin Abstract nyala")
    }
}

// kalau interface Engine ngga pake kurung
class GasolineEngine: Engine {
    override fun start() {
        println("Mesin Bensin Nyala")
    }
}

class ElectricEngine: Engine {
    override fun start() {
        println("Mesin Listrik Nyala")
    }
}

class DieselEngine: Engine {

}