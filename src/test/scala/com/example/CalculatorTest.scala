package com.example

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class CalculatorTest extends AnyFunSuite with Matchers:

  val calculator = new Calculator

  test("Calculator should add two numbers correctly"):
    calculator.add(2, 3) shouldBe 5
    calculator.add(-1, 1) shouldBe 0
    calculator.add(0, 0) shouldBe 0

  test("Calculator should subtract two numbers correctly"):
    calculator.subtract(5, 3) shouldBe 2
    calculator.subtract(0, 5) shouldBe -5
    calculator.subtract(10, 10) shouldBe 0

  test("Calculator should multiply two numbers correctly"):
    calculator.multiply(4, 5) shouldBe 20
    calculator.multiply(-3, 4) shouldBe -12
    calculator.multiply(0, 100) shouldBe 0

  test("Calculator should divide two numbers correctly"):
    calculator.divide(10, 2) shouldBe Some(5)
    calculator.divide(7, 3) shouldBe Some(2)
    calculator.divide(0, 5) shouldBe Some(0)

  test("Calculator should return None when dividing by zero"):
    calculator.divide(5, 0) shouldBe None
    calculator.divide(0, 0) shouldBe None

  test("Calculator should calculate power correctly"):
    calculator.power(2, 3) shouldBe 8
    calculator.power(5, 2) shouldBe 25
    calculator.power(10, 0) shouldBe 1
    calculator.power(3, 1) shouldBe 3
