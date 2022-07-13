package leni.date_220706;
/*
* URL : https://leetcode.com/problems/remove-element/
* */

import leni.Solution;

import java.util.Arrays;

public class RemoveElement implements Solution {

    public RemoveElement(){
        run(this);
    }

    @Override
    public void process() {
  /*      int[] num = {3, 2, 2, 3};
        int val = 3;
        System.out.println(this.removeElement(num, val));*/

        int[] num1 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val1 = 2;
        System.out.println(this.removeElement(num1, val1));

/*        int[] num2 = {1};
        int val2 = 1;
        System.out.println(this.removeElement(num2, val2));*/
    }

    public int removeElement(int[] nums, int val) {

        if(nums.length == 0){
            return  0;
        }

        int endIndex = nums.length-1;
        for(int index=0; index<nums.length; index++){
            if(nums[index] != val)
                continue;

            endIndex = getEndIndex(nums, endIndex, val);

            if(index <= endIndex){
                nums[index] = nums[endIndex];
                nums[endIndex] = val;
            }
            else {
                break;
            }
        }

//        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
        return endIndex+1;
    }

    private int getEndIndex(int[] nums, int endIndex, int val){
         if(endIndex != -1 && nums[endIndex] == val){
            return  getEndIndex(nums, endIndex-1, val);
        }
        return endIndex;
    }
}
