package com.leetcode.backtracking

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
