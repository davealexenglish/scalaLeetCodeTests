package com.davealexenglish.leetcode.test

class CombinationSumTest {
  trait BacktrackingState[State, Candidate] {
    def isSolution: Boolean
    def getCandidates: List[Candidate]
    def applyCandidate(candidate: Candidate): BacktrackingState[State, Candidate]
    def getResult: State
  }

  object Backtracker {
    def findAllSolutions[State, Candidate](
      initialState: BacktrackingState[State, Candidate]
    ): List[BacktrackingState[State, Candidate]] = {
      def backtrack(
        state: BacktrackingState[State, Candidate]
      ): List[BacktrackingState[State, Candidate]] =
        if (state.isSolution) {
          List(state)
        } else {
          state.getCandidates.flatMap(candidate => backtrack(state.applyCandidate(candidate)))
        }
      backtrack(initialState)
    }
  }

  trait CombinationValidator {
    protected val remaining: Int
    protected val combination: List[Int]

    def isValid: Boolean = remaining >= 0
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
