package com.example

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class MathUtilsTest extends AnyFunSuite with Matchers:

  test("isEven should correctly identify even numbers"):
    MathUtils.isEven(2) shouldBe true
    MathUtils.isEven(0) shouldBe true
    MathUtils.isEven(-4) shouldBe true
    MathUtils.isEven(1) shouldBe false
    MathUtils.isEven(3) shouldBe false

  test("isOdd should correctly identify odd numbers"):
    MathUtils.isOdd(1) shouldBe true
    MathUtils.isOdd(3) shouldBe true
    MathUtils.isOdd(-5) shouldBe true
    MathUtils.isOdd(2) shouldBe false
    MathUtils.isOdd(0) shouldBe false

  test("factorial should calculate correctly"):
    MathUtils.factorial(0) shouldBe BigInt(1)
    MathUtils.factorial(1) shouldBe BigInt(1)
    MathUtils.factorial(5) shouldBe BigInt(120)
    MathUtils.factorial(10) shouldBe BigInt(3628800)

  test("fibonacci should calculate correctly"):
    MathUtils.fibonacci(0) shouldBe 0
    MathUtils.fibonacci(1) shouldBe 1
    MathUtils.fibonacci(5) shouldBe 5
    MathUtils.fibonacci(10) shouldBe 55

  test("isPrime should correctly identify prime numbers"):
    MathUtils.isPrime(2) shouldBe true
    MathUtils.isPrime(3) shouldBe true
    MathUtils.isPrime(7) shouldBe true
    MathUtils.isPrime(11) shouldBe true
    MathUtils.isPrime(1) shouldBe false
    MathUtils.isPrime(4) shouldBe false
    MathUtils.isPrime(9) shouldBe false
    MathUtils.isPrime(0) shouldBe false
    MathUtils.isPrime(-5) shouldBe false
