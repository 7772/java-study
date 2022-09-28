/**
 * 문제
 * 남북으로 흐르는 개울에 동서로 징검다리가 놓여져 있다.
 *
 * 이 징검다리의 돌은 들쑥날쑥하여 높이가 모두 다르다. 철수는 개울의 서쪽에서 동쪽으로 높이가 점점 높은 돌을 밟으면서 개울을 지나가려고 한다.
 * 돌의 높이가 서쪽의 돌부터 동쪽방향으로 주어졌을 때 철수가 밟을 수 있는 돌의 최대 개수는?
 *
 * 제약조건
 * 1 ≤ N ≤ 3×103 인 정수
 *
 * 1 ≤ Ai ≤ 108 인 정수
 *
 * 입력형식
 * 첫 번째 줄에 돌의 개수 N이 주어진다.
 *
 * 두 번째 줄에 돌의 높이 Ai (1 ≤ i ≤ N)가 서쪽부터 동쪽으로 차례로 주어진다.
 *
 * 출력형식
 * 첫 번째 줄에 철수가 밟을 수 있는 돌의 최대 개수를 출력하라.
 *
 * 입력예제1
 * 5
 * 3 2 1 4 5
 *
 * 출력예제1
 * 3
 */

import java.io.*;
import java.util.*;

public class Solution3 {

    private static int N;
    private static int[] array;
    private static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        array = new int[N];
        result = new int[N];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
            result[i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
        }

        Arrays.sort(result);
        System.out.println((result[result.length - 1]));
    }
}
