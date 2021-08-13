package com.example

import com.sun.jdi.InvalidTypeException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LengthTest : StringSpec({
    "should add two length with same type and return it in first" {
        Metric(1.0, Measure.Meter).add(Metric(2.0, Measure.Meter)) shouldBe Metric(3.0, Measure.Meter)
    }

    "should add two length with different type and return it in first" {
        Metric(1.0, Measure.Meter).add(Metric(2.0, Measure.Centimeter)) shouldBe Metric(1.02, Measure.Meter)
        Metric(1.0, Measure.Centimeter).add(Metric(2.0, Measure.Millimeter)) shouldBe Metric(1.2, Measure.Centimeter)
        Metric(1.0, Measure.Millimeter).add(Metric(2.0, Measure.Meter)) shouldBe Metric(2001.0, Measure.Millimeter)
    }

    "should convert meter into target unit" {
        Metric(1.0, Measure.Meter).convert(Measure.Centimeter) shouldBe Metric(100.0, Measure.Centimeter)
        Metric(1.0, Measure.Meter).convert(Measure.Millimeter) shouldBe Metric(1000.0, Measure.Millimeter)
    }

    "should convert centimeter into target unit" {
        Metric(1.0, Measure.Centimeter).convert(Measure.Meter) shouldBe Metric(0.01, Measure.Meter)
        Metric(1.0, Measure.Centimeter).convert(Measure.Millimeter) shouldBe Metric(10.0, Measure.Millimeter)
    }

    "should convert millimeter into target unit" {
        Metric(1.0, Measure.Millimeter).convert(Measure.Centimeter) shouldBe Metric(0.1, Measure.Centimeter)
        Metric(1.0, Measure.Millimeter).convert(Measure.Meter) shouldBe Metric(0.001, Measure.Meter)
    }

    "should convert kg into target unit" {
        Metric(1.0, Weights.Kilograms).convert(Weights.Grams) shouldBe Metric(1000.0, Weights.Grams)
        Metric(1.0, Weights.Pounds).convert(Weights.Grams) shouldBe Metric(453.0, Weights.Grams)
        Metric(1.0, Weights.Grams).convert(Weights.Grams) shouldBe Metric(1.0, Weights.Grams)
    }

    "should add two similar weights Unit" {
        Metric(1.0, Weights.Kilograms).add(Metric(1.0, Weights.Kilograms)) shouldBe Metric(2.0, Weights.Kilograms)
    }

    "should add two different weight unit" {
        Metric(1.0, Weights.Kilograms).add(Metric(100.0, Weights.Grams)) shouldBe Metric(1.1, Weights.Kilograms)
        Metric(1.0, Weights.Kilograms).add(Metric(1.0, Weights.Pounds)) shouldBe Metric(1.453, Weights.Kilograms)
    }

    "should throw an exception when weight and measure are passed for addition and vice-versa" {
        shouldThrow<InvalidTypeException> {
            Metric(1.0, Weights.Kilograms).add(Metric(1.0, Measure.Meter))
            Metric(1.0, Measure.Meter).add(Metric(1.0, Weights.Kilograms))
        }
    }
})
