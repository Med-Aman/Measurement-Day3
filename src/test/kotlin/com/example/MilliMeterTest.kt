package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MilliMeterTest : StringSpec({
    "should add two MilliMeter" {
        val expected = (MilliMeter(1.0) + MilliMeter(2.0)).length
        expected shouldBe 3.0
    }

    "should convert into cm" {
        MilliMeter(1.0).convertIntoCm() shouldBe 0.1
    }

    "should convert into meter" {
        MilliMeter(1.0).convertIntoMeter() shouldBe 0.001
    }

    "should add millimeter to cm and return in millimeter" {
        val expected = (MilliMeter(1.0) + Centimeter(50.0)).length
        expected shouldBe 501
    }

    "should add millimeter to meter and return in millimeter" {
        val expected = (MilliMeter(1.0) + Meter(1.0)).length
        expected shouldBe 1001
    }
})
