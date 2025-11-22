package com.leetcode.backtracking

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class CombinationSumTest extends AnyFunSuite with Matchers {

  val solution = new Solution

  // Helper to compare results regardless of order
  def sortedResult(result: List[List[Int]]): Set[List[Int]] =
    result.map(_.sorted).toSet

  test("Example 1: candidates = [2,3,6,7], target = 7") {
    val candidates = Array(2, 3, 6, 7)
    val target     = 7
    val result     = solution.combinationSum(candidates, target)

    sortedResult(result) shouldBe Set(List(2, 2, 3), List(7))
  }

  test("Example 2: candidates = [2,3,5], target = 8") {
    val candidates = Array(2, 3, 5)
    val target     = 8
    val result     = solution.combinationSum(candidates, target)

    sortedResult(result) shouldBe Set(List(2, 2, 2, 2), List(2, 3, 3), List(3, 5))
  }

  test("Example 3: candidates = [2], target = 1 - no valid combination") {
    val candidates = Array(2)
    val target     = 1
    val result     = solution.combinationSum(candidates, target)

    result shouldBe empty
  }

  test("Single candidate equals target") {
    val candidates = Array(5)
    val target     = 5
    val result     = solution.combinationSum(candidates, target)

    sortedResult(result) shouldBe Set(List(5))
  }

  test("Single candidate used multiple times") {
    val candidates = Array(2)
    val target     = 6
    val result     = solution.combinationSum(candidates, target)

    sortedResult(result) shouldBe Set(List(2, 2, 2))
  }

  test("Target is zero - empty combination") {
    val candidates = Array(1, 2, 3)
    val target     = 0
    val result     = solution.combinationSum(candidates, target)

    // Zero target should return empty combination (sum of nothing is 0)
    result shouldBe List(List())
  }

  test("Multiple ways to reach same target") {
    val candidates = Array(1, 2)
    val target     = 4
    val result     = solution.combinationSum(candidates, target)

    // Possible: [1,1,1,1], [1,1,2], [2,2]
    sortedResult(result) shouldBe Set(
      List(1, 1, 1, 1),
      List(1, 1, 2),
      List(2, 2)
    )
  }

  test("Larger candidates array") {
    val candidates = Array(2, 3, 5, 7)
    val target     = 10
    val result     = solution.combinationSum(candidates, target)

    sortedResult(result) shouldBe Set(
      List(2, 2, 2, 2, 2),
      List(2, 2, 3, 3),
      List(2, 3, 5),
      List(3, 7),
      List(5, 5)
    )
  }

  test("No candidates can form target") {
    val candidates = Array(5, 10, 15)
    val target     = 3
    val result     = solution.combinationSum(candidates, target)

    result shouldBe empty
  }

  test("All candidates larger than target") {
    val candidates = Array(10, 20, 30)
    val target     = 5
    val result     = solution.combinationSum(candidates, target)

    result shouldBe empty
  }

  test("Candidates with 1 - many combinations") {
    val candidates = Array(1, 2)
    val target     = 3
    val result     = solution.combinationSum(candidates, target)

    sortedResult(result) shouldBe Set(
      List(1, 1, 1),
      List(1, 2)
    )
  }

  test("Large target with small candidates") {
    val candidates = Array(2, 3)
    val target     = 12
    val result     = solution.combinationSum(candidates, target)

    // 2*6=12, 2*3+3*2=12, 3*4=12
    sortedResult(result) shouldBe Set(
      List(2, 2, 2, 2, 2, 2),
      List(2, 2, 2, 3, 3),
      List(3, 3, 3, 3)
    )
  }

  class Solution {
    trait CombinationValidator extends Validator {
      protected val remaining: Int
      protected val combination: List[Int]

      override def isValid: Boolean = remaining >= 0
    }

    class CombinationState(
      val candidates: Array[Int],
      val combination: List[Int],
      val remaining: Int,
      val index: Int
    ) extends BacktrackingState[List[Int], Int]
      with CombinationValidator {

      def isSolution: Boolean = remaining == 0 && isValid

      def getCandidates: List[Int] =
        if (remaining <= 0) List()
        else {
          (index until candidates.length)
            .filter(i => candidates(i) <= remaining)
            .map(i => candidates(i))
            .toList
        }

      def applyCandidate(num: Int): BacktrackingState[List[Int], Int] = {
        val nextIndex = candidates.indexOf(num, index)
        new CombinationState(
          candidates,
          combination :+ num,
          remaining - num,
          nextIndex
          )
      }

      def getResult: List[Int] = combination
    }

    def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
      val initialState = new CombinationState(candidates, List(), target, 0)
      Backtracker
        .findAllSolutions(initialState)
        .map(_.getResult)
    }
  }
}
