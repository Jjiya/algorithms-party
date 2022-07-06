package leni;
/*
* URL : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
*  in-place algorithm(= 제자리 정렬)
*    - 다른 배열 공간을 생성하지 않고 기존에 있는 배열을 수정하여 정렬하는 것
*    - 대표적으로 버블정렬이 있다.
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
