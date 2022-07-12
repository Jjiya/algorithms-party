package com.party.algorithms.leetcode.easy.hyeji.july_2;

import com.party.algorithms.leetcode.easy.hyeji.Solution;

import java.util.Arrays;

//  로또 최고 순위와 최저 순위
public class theHighestAndLowestRankingsOfTheLotto_77484 implements Solution {
  public theHighestAndLowestRankingsOfTheLotto_77484() {
    run(this);
  }

  @Override
  public void process() {
    int[] lottos = {44, 1, 0, 0, 31, 25};
    int[] win_nums = {31, 10, 45, 1, 6, 19};

    solution(lottos, win_nums);
  }

  public int[] solution(int[] lottos, int[] win_nums) {
    lottos = Arrays.stream(lottos).filter(num -> num != 0).toArray();

    Arrays.sort(lottos);
    Arrays.sort(win_nums);

    int correctCount = 0, winNumIdx = 0, unknownCount = 6 - lottos.length;

    for (int i = 0; i < lottos.length; i++) {
      for (int j = winNumIdx; j < win_nums.length; j++) {
        if (lottos[i] == win_nums[j]) {
          winNumIdx = j + 1;
          correctCount++;
          break;
        }
      }
    }

    int[] answer = {convertRank(Math.min(correctCount + unknownCount, 6)), convertRank(correctCount)};

    return answer;
  }

  public int convertRank(int correctCount) {
    return switch (correctCount) {
      case 6 -> 1;
      case 5 -> 2;
      case 4 -> 3;
      case 3 -> 4;
      case 2 -> 5;
      default -> 6;
    };
  }
}
