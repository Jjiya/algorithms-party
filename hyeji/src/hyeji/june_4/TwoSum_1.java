package hyeji.june_4;

import hyeji.Solution;

public class TwoSum_1 implements Solution {
  TwoSum_1() {
    run(this);
  }

  @Override
  public void process() {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    twoSum(nums, target);
  }

  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return new int[0];
  }
}
