package com.example

/** Companion object with utility math functions */
object MathUtils:

  def isEven(n: Int): Boolean = n % 2 == 0

  def isOdd(n: Int): Boolean = !isEven(n)

  def factorial(n: Int): BigInt =
    if n <= 0 then BigInt(1)
    else BigInt(n) * factorial(n - 1)

  def fibonacci(n: Int): Int =
    n match
      case 0 => 0
      case 1 => 1
      case _ => fibonacci(n - 1) + fibonacci(n - 2)

  def isPrime(n: Int): Boolean =
    if n <= 1 then false
    else if n == 2 then true
    else !(2 until n).exists(i => n % i == 0)
