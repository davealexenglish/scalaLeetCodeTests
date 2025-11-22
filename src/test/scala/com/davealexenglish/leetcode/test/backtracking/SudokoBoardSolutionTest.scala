package com.davealexenglish.leetcode.test.backtracking

import com.davealexenglish.leetcode.test.backtracking.{Backtracker, BacktrackingState, Validator}

object SudokoBoardSolution {
  trait SudokuValidator extends Validator {
    protected val board: Array[Array[Char]]

    protected def validateRow(r: Int): Boolean = {
      val row = board(r)
      !row.filter(_ != '.').groupBy(identity).exists(_._2.length > 1)
    }

    protected def validateCol(c: Int): Boolean = {
      val col = (0 until 9).map(board(_)(c))
      !col.filter(_ != '.').groupBy(identity).exists(_._2.length > 1)
    }

    protected def validateCell(r: Int, c: Int): Boolean = {
      val values = (r until r + 3).map(r => (c until c + 3).map(c => board(r)(c))).flatten
      !values.filter(_ != '.').groupBy(identity).exists(_._2.length > 1)
    }

    override def isValid: Boolean =
      (0 until 9).forall(validateRow(_)) &&
        (0 until 9).forall(validateCol(_)) &&
        (0 until 9 by 3).forall(r => (0 until 9 by 3).forall(c => validateCell(r, c)))
  }

  class SudokuBoard(val board: Array[Array[Char]])
      extends BacktrackingState[Array[Array[Char]], Char]
      with SudokuValidator {

    def isSolution: Boolean =
      !board.exists(_.contains('.')) && isValid

    def getCandidates: List[Char] =
      findEmptyCell() match {
        case None         => List()
        case Some((r, c)) => ('1' to '9').filter(isValidPlacement(r, c, _)).toList
      }

    def applyCandidate(digit: Char): BacktrackingState[Array[Array[Char]], Char] =
      findEmptyCell() match {
        case None => this
        case Some((r, c)) =>
          val newBoard = board.map(_.clone())
          newBoard(r)(c) = digit
          new SudokuBoard(newBoard)
      }

    def getResult: Array[Array[Char]] = board

    private def findEmptyCell(): Option[(Int, Int)] =
      (for { r <- 0 until 9; c <- 0 until 9 if board(r)(c) == '.' } yield (r, c)).headOption

    private def isValidPlacement(r: Int, c: Int, digit: Char): Boolean =
      !board(r).contains(digit) &&
        !(0 until 9).exists(board(_)(c) == digit) && {
          val boxR = (r / 3) * 3
          val boxC = (c / 3) * 3
          !(boxR until boxR + 3).exists(br =>
            (boxC until boxC + 3).exists(bc => board(br)(bc) == digit)
          )
        }
  }

  def solveSudoku(board: Array[Array[Char]]): Unit = {
    val sudokuBoard = new SudokuBoard(board)
    val solution    = Backtracker.findAllSolutions(sudokuBoard).headOption

    solution match {
      case Some(solvedState) =>
        val solvedBoard = solvedState.getResult
        for {
          i <- 0 until 9
          j <- 0 until 9
        }
          board(i)(j) = solvedBoard(i)(j)
      case None => // No solution exists
    }
  }
}
