package hyeji.july_1;

import hyeji.Solution;

public class ImplementStrStr_28 implements Solution {
  public ImplementStrStr_28() {
    run(this);
  }

  @Override
  public void process() {
    String haystack = "mississippi";
    String needle = "issip";

    strStr(haystack, needle);
  }

  public int strStr(String haystack, String needle) {
    int startIdx = -1;
    int sameCount = 0;

    for (int i = 0; i < haystack.length(); i++) {
      if (haystack.charAt(i) == needle.charAt(sameCount)) {
        sameCount++;

        if (startIdx == -1) {
          startIdx = i;
        }
      } else if (sameCount != 0) {
        sameCount = 0;
        i = startIdx;
        startIdx = -1;
      }

      if (sameCount >= needle.length()) {
        break;
      }
    }

    return sameCount == needle.length() ? startIdx : -1;
  }
}
