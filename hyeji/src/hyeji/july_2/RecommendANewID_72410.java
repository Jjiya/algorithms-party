package hyeji.july_2;

import hyeji.Solution;

// 신규 아이디 추천
public class RecommendANewID_72410 implements Solution {
  public RecommendANewID_72410() {
    run(this);
  }

  @Override
  public void process() {
    String new_id = "...!@BaT#*..y.abcdefghijklm";
    solution(new_id);
  }

  public String solution(String new_id) {
    String re_new_id = new_id
        .toLowerCase()
        .replaceAll("[^\\w-_.]", "")
        .replaceAll("[.]{2,}", ".")
        .replaceAll("^[.]|[.]$", "");

    if (re_new_id.isEmpty()) {
      re_new_id = "a";
    }

    if (re_new_id.length() >= 16) {
      re_new_id = re_new_id
          .substring(0, 15)
          .replaceAll("[.]$", "");
    }

    while (re_new_id.length() < 3) {
      re_new_id += re_new_id.charAt(re_new_id.length() - 1);
    }

    return re_new_id;
  }
}
