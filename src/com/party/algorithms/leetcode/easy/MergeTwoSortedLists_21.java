package com.party.algorithms.leetcode.easy;

import com.party.algorithms.leetcode.easy.classDefinition.ListNode;

public class MergeTwoSortedLists_21 {

  public ListNode hyeji(ListNode list1, ListNode list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;

    ListNode sorted = new ListNode();
    if (list1.val < list2.val) {
      sorted.val = list1.val;
      sorted.next = hyeji(list1.next, list2);
    } else {
      sorted.val = list2.val;
      sorted.next = hyeji(list1, list2.next);
    }

    return sorted;
  }

}
