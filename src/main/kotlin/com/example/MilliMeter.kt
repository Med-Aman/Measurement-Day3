package com.example

class MilliMeter(val length: Double) {
    operator fun plus(c1: MilliMeter) = MilliMeter(length + c1.length)
    operator fun plus(cm: Centimeter) = Meter(this.length + cm.convertIntoMm())
    operator fun plus(m: Meter) = Meter(this.length + m.convertIntoMm())

    fun convertIntoCm(): Double = Centimeter(this.length / 10).length
    fun convertIntoMeter(): Double = Meter(this.length / 1000).length
}
