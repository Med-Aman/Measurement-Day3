package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CentimeterTest : StringSpec({
    "should add two Centimeter" {
        val expected = (Centimeter(1.0) + Centimeter(2.0)).length
        expected shouldBe 3.0
    }

    "should convert into meter" {
        Centimeter(1.0).convertIntoMeter() shouldBe 0.01
    }

    "should convert into mm" {
        Centimeter(1.0).convertIntoMm() shouldBe 10.0
    }

    "should add centimeter and meter and return meter" {
        val expected = (Centimeter(1.0) + Meter(1.0)).length
        expected shouldBe 101
    }

    "should add centimeter and millimeter and return centimeter" {
        val expected = (Centimeter(1.0) + MilliMeter(1.0)).length
        expected shouldBe 1.1
    }
})
