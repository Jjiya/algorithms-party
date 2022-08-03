package leni.date_220803;

import leni.Solution;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/67256
 */

class UserPoint {

    int leftPoint = 10;
    int rightPoint = 12;

    public void setHands(String hand, int num){
        if(hand.equals("R")){
            setRightPoint(num);
        }
        else {
            setLeftPoint(num);
        }
    }

    public int getLeftPoint() {
        return leftPoint;
    }

    private void setLeftPoint(int leftPoint) {
        this.leftPoint = leftPoint;
    }

    public int getRightPoint() {
        return rightPoint;
    }

    private void setRightPoint(int rightPoint) {
        this.rightPoint = rightPoint;
    }
}

public class 카카오인턴_키패드누르기 implements Solution {

    public 카카오인턴_키패드누르기(){ run(this); }

    @Override
    public void process() {
/*        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers, hand));*/

        int[] numbers1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand1 = "right";
        System.out.println(solution(numbers1, hand1));
    }

    public String solution(int[] numbers, String hand) {

        StringBuilder answer = new StringBuilder();

        UserPoint userPoint = new UserPoint();

        String lastMoveFinger = "";

        for(int num : numbers){

            switch (num % 3){
                case 1:
                    lastMoveFinger = "L";
                    break;

                case 2:
                    int leftLength = getLength(userPoint.getLeftPoint(), num);
                    int rightLength = getLength(userPoint.getRightPoint(), num);

                    if(leftLength > rightLength) {
                        lastMoveFinger = "R";
                    } else if(leftLength < rightLength) {
                        lastMoveFinger = "L";
                    } else {
                        lastMoveFinger = hand.equals("right") ? "R" : "L";
                    }
                    break;

                case 0:
                    lastMoveFinger = "R";
                    break;

                default:  break;
            }

            userPoint.setHands(lastMoveFinger, num);
            answer.append(lastMoveFinger);
        }

        return answer.toString();
    }

    private int getLength(int index, int number) {

        // 22-08-03 #leni TODO : 공식이 잘못 된 거 같은데 ? ^^;;
        index = (index == 0) ? 11 : index;
        number = (number == 0) ? 11 : number;

        int x = (index - 1) / 3;
        int y = (index - 1) % 3;
        int numberX = number / 3;
        int numberY = 1;

        return Math.abs(x-numberX) + Math.abs(y-numberY);
    }

}
