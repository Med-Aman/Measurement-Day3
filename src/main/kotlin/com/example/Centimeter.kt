package com.example

class Centimeter(val length: Double) {
    operator fun plus(c1: Centimeter) = Centimeter(length + c1.length)

    operator fun plus(m: Meter) = Centimeter(this.length + m.convertIntoCm())
    operator fun plus(mm: MilliMeter) = MilliMeter(this.length + mm.convertIntoCm())

    fun convertIntoMm(): Double = MilliMeter(this.length * 10).length
    fun convertIntoMeter(): Double = Meter(this.length / 100).length
}
