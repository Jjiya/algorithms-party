package com.party.algorithms.leetcode.easy.hyeji.july_1;

import com.party.algorithms.leetcode.easy.hyeji.Solution;

public class RemoveDuplicatesFromSortedArray_26 implements Solution {
  public RemoveDuplicatesFromSortedArray_26() {
    run(this);
  }

  @Override
  public void process() {
    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    removeDuplicates(nums);
  }

  public int removeDuplicates(int[] nums) {
    int index = 0;

    for (int i = 0; i < nums.length; i++) {
      if (i == nums.length - 1 || nums[i] < nums[i + 1]) {
        nums[index++] = nums[i];
      }
    }

    return index;
  }
}
