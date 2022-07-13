package leni.date_220706;
/*
* URL : https://leetcode.com/problems/implement-strstr/
* */

import leni.Solution;

public class StrStr implements Solution {

    public StrStr(){
        run(this);
    }

    @Override
    public void process() {
        String haystack = "hello";
        String needle = "ll";

        System.out.println(strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

}
