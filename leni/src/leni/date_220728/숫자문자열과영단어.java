package leni.date_220728;

import leni.Solution;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/81301
 */

public class 숫자문자열과영단어 implements Solution {

    public 숫자문자열과영단어() { run(this); }

    private final String[] NUMBERS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    @Override
    public void process() {
        String[] input = {
                "one4seveneight"
                , "123"
                , "23four5six7"
                , "1zerotwozero3"
                , "oneoneoneoneone"
                , "oneone345"
        };

        for(String in : input){
            System.out.println(in+" >> "+solution(in));
        }
    }

    public int solution(String s){
        for (int idx=0; idx < NUMBERS.length; idx++) {
            s = s.replace(NUMBERS[idx], Integer.toString(idx));
        }

        return Integer.parseInt(s);
    }

    public int solution2(String s){
        /**
         *  정규표현식 비교를 시작하면, if 를 한 번 더 타게 되서 느려진다!
         *  그냥 for 돌리자 ^^.. ㅜ
         */


        for (int idx=0; idx < NUMBERS.length; idx++) {

            // 영문자가 포함되어 있는지 검색
            boolean isAllNumbers = !s.matches(".*[a-z|A-Z].*");
            if(isAllNumbers) {
                break;
            }
            s = s.replace(NUMBERS[idx], Integer.toString(idx));
        }

        return Integer.parseInt(s);
    }
}
