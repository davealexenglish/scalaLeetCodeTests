package com.davealexenglish.leetcode.test

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SudokoBoardTest extends AnyFunSuite with Matchers {

  test("valid sudoku - example 1") {
    val board = Array(
      Array('5', '3', '.', '.', '7', '.', '.', '.', '.'),
      Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
      Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
      Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
      Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
      Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
      Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
      Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
      Array('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    Solution.isValidSudoku(board) should be(true)
  }

  test("invalid sudoku - duplicate in 3x3 box - example 2") {
    val board = Array(
      Array('8', '3', '.', '.', '7', '.', '.', '.', '.'),
      Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
      Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
      Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
      Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
      Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
      Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
      Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
      Array('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    Solution.isValidSudoku(board) should be(false)
  }

  test("invalid sudoku - duplicate in row") {
    val board = Array(
      Array('5', '5', '.', '.', '7', '.', '.', '.', '.'),
      Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
      Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
      Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
      Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
      Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
      Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
      Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
      Array('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    Solution.isValidSudoku(board) should be(false)
  }

  test("invalid sudoku - duplicate in column") {
    val board = Array(
      Array('5', '3', '.', '.', '7', '.', '.', '.', '.'),
      Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
      Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
      Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
      Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
      Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
      Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
      Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
      Array('5', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    Solution.isValidSudoku(board) should be(false)
  }

  test("valid sudoku - completely filled") {
    val board = Array(
      Array('5', '3', '4', '6', '7', '8', '9', '1', '2'),
      Array('6', '7', '2', '1', '9', '5', '3', '4', '8'),
      Array('1', '9', '8', '3', '4', '2', '5', '6', '7'),
      Array('8', '5', '9', '7', '6', '1', '4', '2', '3'),
      Array('4', '2', '6', '8', '5', '3', '7', '9', '1'),
      Array('7', '1', '3', '9', '2', '4', '8', '5', '6'),
      Array('9', '6', '1', '5', '3', '7', '2', '8', '4'),
      Array('2', '8', '7', '4', '1', '9', '6', '3', '5'),
      Array('3', '4', '5', '2', '8', '6', '1', '7', '9')
    )

    Solution.isValidSudoku(board) should be(true)
  }

  test("valid sudoku - mostly empty") {
    val board = Array(
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '5', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.')
    )

    Solution.isValidSudoku(board) should be(true)
  }

  test("valid sudoku - empty board") {
    val board = Array(
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.')
    )

    Solution.isValidSudoku(board) should be(true)
  }

  test("invalid sudoku - duplicate 9s in middle 3x3 box") {
    val board = Array(
      Array('5', '3', '.', '.', '7', '.', '.', '.', '.'),
      Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
      Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
      Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
      Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
      Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
      Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
      Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
      Array('.', '.', '.', '.', '9', '.', '.', '7', '9')
    )

    Solution.isValidSudoku(board) should be(false)
  }

  test("valid sudoku - single digit in each region") {
    val board = Array(
      Array('1', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '2', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '3', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '4', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '5', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '6', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '7', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '8', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '9')
    )

    Solution.isValidSudoku(board) should be(true)
  }

  test("invalid sudoku - duplicate at edges of 3x3 boxes") {
    val board = Array(
      Array('1', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '1', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.')
    )

    Solution.isValidSudoku(board) should be(false)
  }

  test("valid sudoku - all corners filled with different digits") {
    val board = Array(
      Array('1', '.', '.', '.', '.', '.', '.', '.', '2'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      Array('3', '.', '.', '.', '.', '.', '.', '.', '4')
    )

    Solution.isValidSudoku(board) should be(true)
  }
}

object Solution {
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    class SudokuBoard(val board: Array[Array[Char]]) {
      private def validateRow(r: Int): Boolean = {
        val row = board(r)
        !row.filter(_ != '.').groupBy(identity).exists(_._2.length > 1)
      }

      private def validateCol(c: Int): Boolean = {
        val col = (0 until 9).map(board(_)(c))
        !col.filter(_ != '.').groupBy(identity).exists(_._2.length > 1)
      }

      private def validateCell(r: Int, c: Int): Boolean = {
        val values = (r until r + 3).map(r => (c until c + 3).map(c => board(r)(c))).flatten
        !values.filter(_ != '.').groupBy(identity).exists(_._2.length > 1)
      }

      def isValid(): Boolean =
        (0 until 9).forall(validateRow(_)) &&
          (0 until 9).forall(validateCol(_)) &&
          (0 until 9 by 3).forall(r => (0 until 9 by 3).forall(c => validateCell(r, c)))
    }
    new SudokuBoard(board.map(_.clone())).isValid()
  }
}
