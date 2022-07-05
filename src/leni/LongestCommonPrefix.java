package leni;
/*
* URL : https://leetcode.com/problems/longest-common-prefix/
* */

import java.util.Arrays;

public class LongestCommonPrefix implements Solution {

    LongestCommonPrefix(){
        run(this);
    }

    @Override
    public void process() {
        String[] strs = {"flower","flow","flight"};
        String[] strs1 = {"dog","racecar","car"};

        System.out.println(this.longestCommonPrefix(strs));
        System.out.println(this.longestCommonPrefix(strs1));
    }

    public String longestCommonPrefix(String[] strs){

        if(strs.length == 0){
            return "";
        }

        Arrays.sort(strs);

        String firstStr = strs[0];
        String lastStr = strs[strs.length -1];

        StringBuilder commonPrefix = new StringBuilder();

        for(int index = 0; index < firstStr.length(); index++){
            if(firstStr.charAt(index) == lastStr.charAt(index)){
                commonPrefix.append(firstStr.charAt(index));
            }
            else {
                break;
            }
        }

        return commonPrefix.toString();
    }

}
