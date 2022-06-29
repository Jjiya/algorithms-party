package com.party.algorithms.leetcode.easy;

import java.util.Stack;

public class ValidParentheses_20 {

  public boolean hyeji(String s) {
    Stack<Character> brackets = new Stack<>();
    Stack<Character> waitClose = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      brackets.push(s.charAt(i));
    }

    while (!brackets.empty()) {
      char bracket = brackets.pop();

      if (waitClose.empty()) {
        waitClose.push(bracket);
      } else {
        if (waitClose.peek() == getReverseBracket(bracket)) {
          waitClose.pop();
        } else {
          waitClose.push(bracket);
        }
      }
    }

    return waitClose.empty();
  }

  char getReverseBracket(char bracket) {
    return switch (bracket) {
      case '(' -> ')';
      case '[' -> ']';
      case '{' -> '}';
      default -> ' ';
    };
  }

}
