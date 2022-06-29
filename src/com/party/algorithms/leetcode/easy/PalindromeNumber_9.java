package com.party.algorithms.leetcode.easy;

public class PalindromeNumber_9 {

  public boolean hyeji(int x) {
    return (x + "").contentEquals(new StringBuilder().append(x).reverse());
  }

}
