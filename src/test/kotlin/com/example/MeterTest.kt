package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MeterTest : StringSpec({
    "should add two Meter" {
        val expected = (Meter(1.0) + Meter(2.0)).length
        expected shouldBe 3.0
    }

    "should convert into cm" {
        Meter(1.0).convertIntoCm() shouldBe 100.0
    }

    "should convert into mm" {
        Meter(1.0).convertIntoMm() shouldBe 1000.0
    }

    "should add meter to cm and return in meter" {
        val expected = (Meter(1.0) + Centimeter(50.0)).length
        expected shouldBe 1.5
    }

    "should add meter to mm and return in meter" {
        val expected = (Meter(1.0) + MilliMeter(10.0)).length
        expected shouldBe 1.01
    }
})
