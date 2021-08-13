package com.example

data class Length(
    val value: Double,
    val unit: Unit
) {
    fun add(length: Length): Length {
        val convertedValue = length.convert(unit).value
        return Length(
            convertedValue + this.value, this.unit
        )
    }

    fun convert(targetUnit: Unit) = Length((value * unit.scale) / targetUnit.scale, targetUnit)
}

enum class Unit(val scale: Double) {
    Meter(100.0), Centimeter(1.0), Millimeter(0.1)
}
