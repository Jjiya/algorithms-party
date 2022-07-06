package leni;
/*
* URL : https://leetcode.com/problems/implement-strstr/
* */

public class StrStr implements Solution {

    StrStr(){
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
