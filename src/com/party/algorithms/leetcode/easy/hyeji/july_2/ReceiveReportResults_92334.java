package com.party.algorithms.leetcode.easy.hyeji.july_2;

import com.party.algorithms.leetcode.easy.hyeji.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

//신고 결과 받기
public class ReceiveReportResults_92334 implements Solution {
  public ReceiveReportResults_92334() {
    run(this);
  }

  @Override
  public void process() {
    String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
    int k = 2;

    solution(id_list, report, k);
  }

  public int[] solution(String[] id_list, String[] report, int k) {
    /*
        1. 유저 별 신고한 유저를 저장한다.
            key value 형식 이용
            key: 신고 당한 유저, value: String[] 신고한 유저 리스트
        2. 신고된 횟수가 k번 이상인 유저를 찾는다.
            key로 반복문 돌려서 그에 해당하는 길이가 k번 이상인 것
        3. 2에 해당하는 유저를 신고한 유저를 찾는다.
        4. 3에 해당하는 유저가 받을 메일 수를 저장한다.
    */
    HashMap<String, HashSet<String>> reportList = new HashMap<>(id_list.length);
    HashSet<String> reportedThanK = new HashSet<>();

    for (String reportInfo : report) {
      StringTokenizer st = new StringTokenizer(reportInfo);
      String userId = st.nextToken(), reportId = st.nextToken();
      HashSet<String> userList = reportList.getOrDefault(reportId, new HashSet<>());
      userList.add(userId);
      reportList.put(reportId, userList);

      if (userList.size() == k) {
        reportedThanK.add(reportId);
      }
    }

    int[] answer = new int[id_list.length];

    if (reportedThanK.size() != 0) {
      for (int i = 0; i < id_list.length; i++) {
        for (String reportId : reportedThanK) {
          if (reportList.get(reportId).contains(id_list[i])) {
            answer[i]++;
          }
        }
      }
    }

    return answer;
  }
}
