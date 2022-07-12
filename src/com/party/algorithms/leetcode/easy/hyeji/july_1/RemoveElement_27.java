package com.party.algorithms.leetcode.easy.hyeji.july_1;

import com.party.algorithms.leetcode.easy.hyeji.Solution;

import java.util.Arrays;

public class RemoveElement_27 implements Solution {
  public RemoveElement_27() {
    run(this);
  }

  @Override
  public void process() {
    int[] nums = {3, 2, 2, 3};
    int val = 3;
    removeElement(nums, val);
  }

  public int removeElement(int[] nums, int val) {
    int count = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == val) {
        nums[i] = 101;
        count++;
      }
    }

    Arrays.sort(nums);

    return nums.length - count;
  }
}
