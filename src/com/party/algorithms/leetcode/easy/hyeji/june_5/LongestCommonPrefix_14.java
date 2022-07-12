package com.party.algorithms.leetcode.easy.hyeji.june_5;

import com.party.algorithms.leetcode.easy.hyeji.Solution;

public class LongestCommonPrefix_14 implements Solution {

  LongestCommonPrefix_14() {
    run(this);
  }

  @Override
  public void process() {
    String[] strs = {"flower", "flow", "flight"};
    longestCommonPrefix(strs);
  }

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 1) {
      return strs[0];
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < strs[0].toCharArray().length; i++) {
      char prefix = strs[0].charAt(i);
      boolean isSame = false;

      for (int j = 1; j < strs.length; j++) {
        if (strs[j].length() <= i) {
          isSame = false;
          break;
        }

        isSame = prefix == strs[j].charAt(i);

        if (!isSame) break;
      }

      if (isSame) {
        sb.append(prefix);
      } else {
        break;
      }
    }

    return sb.toString();
  }
}
