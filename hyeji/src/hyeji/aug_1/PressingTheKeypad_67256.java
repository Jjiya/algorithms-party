package hyeji.aug_1;

import hyeji.Solution;

// [카카오 인턴] 키패드 누르기
public class PressingTheKeypad_67256 implements Solution {
  public PressingTheKeypad_67256() {
    run(this);
  }

  @Override
  public void process() {
    String result = solution(new int[]{1, 0, 9, 5, 3, 6, 7, 2}, "left");
    System.out.println(result);
  }

  /*
    << 아래 규칙을 만족시키기 위해선 "* = 10", "0 = 11", "# = 12"로 규정해야함 >>

    1,4,7,*(=10) : num % 3 == 1
    2,5,8,0(=11) : num % 3 = 2
    3,6,9,#(=12) : num % 3 == 0

    거리 = ((current Number - next Number) / 3) + ((current Number - next Number) % 3)
    1 > 5 : 5-1 = (4 / 3) + (4 % 3) = 1 + 1 = 2
    1 > 8 : 8-1 = (7 / 3) + (7 % 3) = 2 + 1 = 3
    2 > 8 : 8-2 = (6 / 3) + (6 % 3) = 2 + 0 = 2
    9 > 2 : 9-2 = (7 / 3) + (7 % 3) = 2 + 1 = 3
    7 > 0 : 11-7 = (4 / 3) + (4 % 3) = 1 + 1 = 2
    # > 2 : 12-2 = (10 / 3) + (10 % 3) = 3 + 1 = 4
*/
  public int leftHand = 10, rightHand = 12;
  public StringBuilder sb = new StringBuilder();

  public String solution(int[] numbers, String hand) {
    for (int nextNumber : numbers) {
      if (nextNumber == 0) nextNumber = 11;
      String copyHand = hand;

      int remainder = nextNumber % 3;

      if (remainder == 1) {
        copyHand = "left";
      } else if (remainder == 0) {
        copyHand = "right";
      } else {
        int leftLocation = getLocation(leftHand, nextNumber);
        int rightLocation = getLocation(rightHand, nextNumber);

        if (leftLocation < rightLocation) {
          copyHand = "left";
        } else if (leftLocation > rightLocation) {
          copyHand = "right";
        }
      }

      saveHandValue(copyHand, nextNumber);
    }

    return sb.toString();
  }

  public void saveHandValue(String hand, int nextNumber) {
    if (hand.equals("left")) {
      leftHand = nextNumber;
      sb.append("L");
    } else {
      rightHand = nextNumber;
      sb.append("R");
    }
  }

  public int getLocation(int currentNumber, int nextNumber) {
    int minusValue = Math.abs(currentNumber - nextNumber);

    return (minusValue / 3) + (minusValue % 3);
  }

  /* ************************ 아래는 하드 코딩 ************************ */

  public String solution1(int[] numbers, String hand) {
    int[][] coordinate = {
//             0        1       2       3
        {3, 1}, {0, 0}, {0, 1}, {0, 2},
//             4        5       6       7
        {1, 0}, {1, 1}, {1, 2}, {2, 0},
//             8        9       *       #
        {2, 1}, {2, 2}, {3, 0}, {3, 2}
    };

    int left = 10, right = 11;

    StringBuilder sb = new StringBuilder();

    for (int num : numbers) {
      if (num % 3 == 0 && num != 0) {   // 숫자 3, 6, 9
        right = num;
        sb.append("R");
      } else if (num % 3 == 1) {    // 숫자 1, 4, 7
        left = num;
        sb.append("L");
      } else {  // 2, 5, 8, 0
        int leftDist = Math.abs(coordinate[left][0] - coordinate[num][0]) + Math.abs(coordinate[left][1] - coordinate[num][1]);
        int rightDist = Math.abs(coordinate[right][0] - coordinate[num][0]) + Math.abs(coordinate[right][1] - coordinate[num][1]);
        int diff = leftDist - rightDist;
        if (diff < 0) {
          left = num;
          sb.append("L");
        } else if (diff > 0) {
          right = num;
          sb.append("R");
        } else {
          if (hand.equals("left")) {
            left = num;
            sb.append("L");
          } else {
            right = num;
            sb.append("R");
          }
        }
      }
    }   // end for

    return sb.toString();
  }
}
