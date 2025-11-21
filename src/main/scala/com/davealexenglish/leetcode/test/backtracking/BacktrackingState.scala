package com.davealexenglish.leetcode.test.backtracking

trait BacktrackingState[State, Candidate] {
  def isSolution: Boolean
  def getCandidates: List[Candidate]
  def applyCandidate(candidate: Candidate): BacktrackingState[State, Candidate]
  def getResult: State
}
