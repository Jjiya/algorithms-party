package com.party.algorithms.leetcode.easy.hyeji.june_5;

import com.party.algorithms.leetcode.easy.classDefinition.ListNode;
import com.party.algorithms.leetcode.easy.hyeji.Solution;

public class MergeTwoSortedLists_21 implements Solution {

  public MergeTwoSortedLists_21() {
    run(this);
  }

  @Override
  public void process() {
    ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
    ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    mergeTwoLists(list1, list2);
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;

    ListNode sorted = new ListNode();
    if (list1.val < list2.val) {
      sorted.val = list1.val;
      sorted.next = mergeTwoLists(list1.next, list2);
    } else {
      sorted.val = list2.val;
      sorted.next = mergeTwoLists(list1, list2.next);
    }

    return sorted;
  }
}
