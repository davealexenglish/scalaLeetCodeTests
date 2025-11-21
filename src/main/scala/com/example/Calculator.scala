package com.example

/** A simple calculator class demonstrating basic arithmetic operations */
class Calculator:

  def add(a: Int, b: Int): Int = a + b

  def subtract(a: Int, b: Int): Int = a - b

  def multiply(a: Int, b: Int): Int = a * b

  def divide(a: Int, b: Int): Option[Int] =
    if b != 0 then Some(a / b)
    else None

  def power(base: Int, exponent: Int): Int =
    if exponent == 0 then 1
    else base * power(base, exponent - 1)
