package com.party.algorithms.leetcode.easy.hyeji.june_4;

import com.party.algorithms.leetcode.easy.hyeji.Solution;

public class PalindromeNumber_9 implements Solution {
  public PalindromeNumber_9() {
    run(this);
  }

  @Override
  public void process() {
    int x = -121;
    isPalindrome(x);
  }

  public boolean isPalindrome(int x) {
    return (x + "").contentEquals(new StringBuilder().append(x).reverse());
  }

}
