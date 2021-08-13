package com.example

data class Metric(
    val value: Double,
    val unit: Unit
) {
    fun add(metric: Metric): Metric {
        val convertedValue = metric.convert(unit).value
        return Metric(
            convertedValue + this.value, unit
        )
    }

    fun convert(targetUnit: Unit) = Metric((value * unit.scale) / targetUnit.scale, targetUnit)
}

/*
enum class Unit(val scale: Double) {
    Meter(100.0), Centimeter(1.0), Millimeter(0.1),
}
*/
interface Unit {
    val scale: Double
}

enum class Measure(override val scale: Double) : Unit {
    Meter(100.0), Centimeter(1.0), Millimeter(0.1)
}

enum class Weights(override val scale: Double) : Unit {
    Kilograms(1000.0), Grams(1.0), Pounds(453.0)
}
