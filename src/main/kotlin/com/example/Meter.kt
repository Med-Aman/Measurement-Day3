package com.example

class Meter(val length: Double) {
    operator fun plus(c1: Meter) = Meter(length + c1.length)

    operator fun plus(cm: Centimeter) = Meter(this.length + cm.convertIntoMeter())
    operator fun plus(mm: MilliMeter) = Meter(this.length + mm.convertIntoMeter())

    fun convertIntoCm(): Double = Centimeter(this.length * 100).length
    fun convertIntoMm(): Double = MilliMeter(this.length * 1000).length
}
