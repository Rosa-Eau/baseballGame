import java.lang.reflect.Array;
import java.util.*;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 1. 랜덤숫자 만들기
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int[] ansAry = new int[3];
        int answer;

        do {
            // 세 자리 숫자가 다 다를 때까지 생성
            ansAry[0] = random.nextInt(9) + 1;
            ansAry[1] = random.nextInt(9) + 1;
            ansAry[2] = random.nextInt(9) + 1;
        } while (ansAry[0] == ansAry[1] || ansAry[1] == ansAry[2] || ansAry[0] == ansAry[2]);

//        답 확인 테스트용
//        answer = ansAry[0] * 100 + ansAry[1] * 10 + ansAry[2];
//        System.out.println("답 : " + answer);

        System.out.println("야구게임 시작합니다!");
        int inputNum;
        int inputAry[] = new int[3];

        while (true) {
            // 숫자 입력받기
            System.out.println("숫자를 입력하세요(게임을 종료하고 싶으면 0을 입력해주세요)");
            System.out.print(">> ");
            inputNum = sc.nextInt();

            if (inputNum == 0) {
                System.out.println("게임을 종료합니다.");
                break;
            }

            // 배열에 넣기
            inputAry[0] = inputNum / 100;
            inputAry[1] = (inputNum / 10) % 10;
            inputAry[2] = inputNum % 10;

//          배열에 잘 들어갔는지 확인
//          System.out.println(Arrays.toString(inputAry));

            if (checkNum(inputAry)) {
                System.out.println("Error: 같은 숫자를 입력했습니다. 게임을 종료합니다.");
                break;
            }

            // 볼, 스트라이크 숫자 받기
            int ball = ballCount(ansAry,inputAry);
            int strike = strCount(ansAry, inputAry);


            // 볼, 스트라이크 표시하고 3 스트라이크일 시 게임 종료
            if (strike != 3) {
                System.out.println(ball+"B"+strike+"S");
            } else if (strike == 3) {
                System.out.println("정답입니다!");
                System.out.println("WIN!!");
                break;
            }

        }


    }

    // 볼, 스트라이크 확인
    static int ballCount(int[] ansAry, int[] inputAry) {
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && ansAry[i] == inputAry[j]) {
                    ball++;
                }
            }
        }
        return ball;
    }

    static int strCount(int[] ansAry, int[] inputAry) {
        int strike = 0;

        for (int i = 0; i < ansAry.length; i++) {
            if (ansAry[i] == inputAry[i]) {
                strike++;
            }
        }
        return strike;
    }

    // 중복 값 확인하기
    static boolean checkNum(int[] inputAry) {
        Set<Integer> set = new HashSet<>();

        for (int num : inputAry) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;

    }

}
