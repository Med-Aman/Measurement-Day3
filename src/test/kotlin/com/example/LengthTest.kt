package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LengthTest : StringSpec({
    "should add two length with same type and return it in first" {
        Length(1.0, Unit.Meter).add(Length(2.0, Unit.Meter)) shouldBe Length(3.0, Unit.Meter)
    }

    "should add two length with different type and return it in first" {
        Length(1.0, Unit.Meter).add(Length(2.0, Unit.Centimeter)) shouldBe Length(1.02, Unit.Meter)
        Length(1.0, Unit.Centimeter).add(Length(2.0, Unit.Millimeter)) shouldBe Length(1.2, Unit.Centimeter)
        Length(1.0, Unit.Millimeter).add(Length(2.0, Unit.Meter)) shouldBe Length(2001.0, Unit.Millimeter)
    }

    "should convert meter into target unit" {
        Length(1.0, Unit.Meter).convert(Unit.Centimeter) shouldBe Length(100.0, Unit.Centimeter)
        Length(1.0, Unit.Meter).convert(Unit.Millimeter) shouldBe Length(1000.0, Unit.Millimeter)
    }

    "should convert centimeter into target unit" {
        Length(1.0, Unit.Centimeter).convert(Unit.Meter) shouldBe Length(0.01, Unit.Meter)
        Length(1.0, Unit.Centimeter).convert(Unit.Millimeter) shouldBe Length(10.0, Unit.Millimeter)
    }

    "should convert millimeter into target unit" {
        Length(1.0, Unit.Millimeter).convert(Unit.Centimeter) shouldBe Length(0.1, Unit.Centimeter)
        Length(1.0, Unit.Millimeter).convert(Unit.Meter) shouldBe Length(0.001, Unit.Meter)
    }



})