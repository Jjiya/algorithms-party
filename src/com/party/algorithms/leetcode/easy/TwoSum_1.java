package com.party.algorithms.leetcode.easy;

public class TwoSum_1 {

  public int[] hyeji(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) return new int[]{i, j};
      }
    }
    return null;
  }

}
