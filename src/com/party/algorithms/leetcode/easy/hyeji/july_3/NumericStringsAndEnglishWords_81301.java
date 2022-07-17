package com.party.algorithms.leetcode.easy.hyeji.july_3;

import com.party.algorithms.leetcode.easy.hyeji.Solution;

public class NumericStringsAndEnglishWords_81301 implements Solution {
  public NumericStringsAndEnglishWords_81301() {
    run(this);
  }

  @Override
  public void process() {
    String[] s = {"one4seveneight", "23four5six7", "2three45sixseven", "123"};
    solution(s[0]);
    solution1(s[0]);
  }

  public int solution(String s) {
    int answer = 0;

    for (int i = 0; i < s.length(); i++) {
      char startLetter = s.charAt(i);
      int number = -1;  // 변환해줄 숫자

      if ('a' <= startLetter) { // 현재 글자가 알파벳이라면
        char nextLetter = s.charAt(i + 1);  // 다음 글자 확인
        number = convertCharToNumber(startLetter, nextLetter);  // 현재 글자 + 다음 글자 조합으로 숫자 찾기

        i = getEndIndex(i, number); // 문자를 숫자로 변경해줬으니 index를 현재 영단어가 종료되는 시점으로 변경
      } else {
        number = (int) (startLetter - '0'); // 숫자라면 현재 글자 - '0' 연산을 통해 ascii -> 10진수 변환
      }

      answer = updateAnswer(answer, number);  // answer에 값 다시 저장 -> 현재 숫자를 answer 숫자의 뒤에 붙여줘야해서
    }

    return answer;
  }

  /**
   * 한글자(+ 다음 글자) 읽은 후 -> 숫자 변경
   *
   * @param startLetter 현재 글자
   * @param nextLetter  다음 글자
   * @return int 단어 조합을 이용해 숫자로 변환
   */
  int convertCharToNumber(char startLetter, char nextLetter) {
    return switch (startLetter) {
      case 'z' -> 0;
      case 'o' -> 1;
      case 't' -> nextLetter == 'w' ? 2 : 3;
      case 'f' -> {
        if (nextLetter == 'o') {
          yield 4;
        } else {
          yield 5;
        }
      }
      case 's' -> nextLetter == 'i' ? 6 : 7;
      case 'e' -> 8;
      case 'n' -> 9;
      default -> -1;
    };
  }

  /**
   * 숫자 -> 영단어 변환
   *
   * @param number 영단어로 변환할 숫자
   * @return String 영단어
   */
  String convertNumberToWord(int number) {
    return switch (number) {
      case 0 -> "zero";
      case 1 -> "one";
      case 2 -> "two";
      case 3 -> "three";
      case 4 -> "four";
      case 5 -> "five";
      case 6 -> "six";
      case 7 -> "seven";
      case 8 -> "eight";
      case 9 -> "nine";
      default -> "ERROR";
    };
  }

  /**
   * number에 해당하는 영단어가 끝나는 지점을 구한다.
   *
   * @param i      현재 for 문의 i index
   * @param number 영단어가 끝나는 지점을 구할 숫자
   * @return int i 해당 영단어가 종료되는 시점의 i index
   */
  int getEndIndex(int i, int number) {
    String numberWord = convertNumberToWord(number);

    return i + numberWord.length() - 1;
  }

  /**
   * answer의 값을 업데이트 시킨다.
   *
   * @param answer    최종 return 해줄 answer
   * @param newNumber 새로 구한 숫자
   * @return int 덮어 씌워 줄 answer
   */
  int updateAnswer(int answer, int newNumber) {
//    현재 answer의 자리수 증가 + 새로운 숫자
    return (answer * 10) + newNumber;
  }

  /**
   * 일반 정규식을 이용한 방법
   *
   * @param s 숫자로 변경해야할 문자열
   * @return int
   */
  public int solution1(String s) {
    s = s.replaceAll("zero", "0")
        .replaceAll("one", "1")
        .replaceAll("two", "2")
        .replaceAll("three", "3")
        .replaceAll("four", "4")
        .replaceAll("five", "5")
        .replaceAll("six", "6")
        .replaceAll("seven", "7")
        .replaceAll("eight", "8")
        .replaceAll("nine", "9");

    return Integer.parseInt(s);
  }
}
