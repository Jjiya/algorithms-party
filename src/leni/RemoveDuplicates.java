package leni;
/*
* URL : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
* */

import java.util.Arrays;

public class RemoveDuplicates implements Solution{

    RemoveDuplicates(){
        run(this);
    }

    @Override
    public void process() {
        int[] nums = {0, 1, 2};
        System.out.println(this.removeDuplicates(nums));

        int[] nums1 = {1, 1, 2};
        System.out.println(this.removeDuplicates(nums1));
    }

    public int removeDuplicates(int[] nums){
        if(nums.length <= 1){
            return nums.length;
        }

        int pointIndex = 0;
        for(int index=1; index<nums.length; index++){
            if(nums[index] <= nums[pointIndex]) continue;
                pointIndex++;
                nums[pointIndex] = nums[index];
        }

//        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
        return pointIndex+1;
    }

}
