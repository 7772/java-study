/**
 * 문제
 * 김교수는 강의실 1개에 최대한 많은 강의를 배정하려고 한다. 배정된 강의는 서로 겹치지 않아야 하며 수업시간의 길이와 상관없이 최대한 강의를 많이 배정하라. 단, 두 강의의 시작시간과 종료시간은 겹쳐도 된다.
 *
 * 제약조건
 * 1 ≤ N ≤ 106 인 정수
 * 1 ≤ Si ＜ Fi ≤ 109
 *
 * 입력형식
 * 첫 번째 줄에 강의 개수 N이 주어진다. i + 1 (1 ≤ i ≤ N)번째 줄에는 i번째 강의의 시작 시간 Si와 종료 시간 Fi가 주어진다.
 *
 * 출력형식
 * 첫 번째 줄에 최대 강의 수를 출력하라.
 *
 * 입력예제1
 * 3
 * 1 3
 * 2 4
 * 3 5
 *
 * 출력예제1
 * 2
 */

import java.io.*;
import java.util.*;

public class Solution5 {

    private static int N;
    private static int[][] times;
    private static int count = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        N = Integer.parseInt(br.readLine());

        times = new int[N][2];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                times[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        Arrays.sort(times, (int[] o1, int[] o2) -> {
            return o1[1] - o2[1];
        });

//        System.out.println("--------------------------");
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < 2; j++) {
//                System.out.print(times[i][j]);
//            }
//            System.out.println("");
//        }
//        System.out.println("--------------------------");

        int current = times[0][1];

        for (int i = 0; i < N; i++) {
//            System.out.println("> current: " + current + " start: " + times[i][0]);
            if (current <= times[i][0]) {
                count++;
                current = times[i][1];
            }
        }

        System.out.println(count);
    }
}
