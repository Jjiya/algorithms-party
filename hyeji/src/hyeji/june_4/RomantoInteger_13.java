package hyeji.june_4;

import hyeji.Solution;

import java.util.HashMap;

public class RomantoInteger_13 implements Solution {
  public RomantoInteger_13() {
    run(this);
  }

  @Override
  public void process() {
    String s = "MCMXCIV";
    romanToInt(s);
  }

  public int romanToInt(String s) {
    int sum = 0, i = 0;

    while (i < s.length() - 1) {
      int num = convertRomanToNum(s.charAt(i));
      int nextNum = convertRomanToNum(s.charAt(i + 1));
      if (num < nextNum) {
        sum += nextNum - num;
        i++;
      } else {
        sum += num;
      }
      i++;
    }

//    끝 두자리가 계산 된 경우면 sum 반환, 아니면 sum에 마지막 1글자 더해줘야함.
    return i == s.length() ? sum : sum + convertRomanToNum(s.charAt(s.length() - 1));
  }

  public int romanToInt1(String s) {
    HashMap<String, Integer> romanNumerals = new HashMap<>();
    romanNumerals.put("I", 1);
    romanNumerals.put("V", 5);
    romanNumerals.put("X", 10);
    romanNumerals.put("L", 50);
    romanNumerals.put("C", 100);
    romanNumerals.put("D", 500);
    romanNumerals.put("M", 1000);

    String[] chars = s.split("");

    int answer = 0;
    int[] numeric = new int[chars.length];
    for (int i = 0; i < chars.length; i++) {
      numeric[i] = romanNumerals.get(chars[i]);
    }

    int sum = 0;
    for (int j = 0; j < numeric.length; j++) {
      if (j != numeric.length - 1) {
        int division = numeric[j + 1] / numeric[j];
        if (division == 5 || division == 10) {
          sum += (numeric[j + 1] - numeric[j]);
          j++;
          continue;
        }
      }
      sum += numeric[j];
    }

    return sum;
  }

  int convertRomanToNum(char romanChar) {
    return switch (romanChar) {
      case 'I' -> 1;
      case 'V' -> 5;
      case 'X' -> 10;
      case 'L' -> 50;
      case 'C' -> 100;
      case 'D' -> 500;
      case 'M' -> 1000;
      default -> 0;
    };
  }
}
