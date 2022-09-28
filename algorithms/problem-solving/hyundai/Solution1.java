/**
 * 문제
 * N명의 학생들의 성적이 학번순서대로 주어졌다.
 *
 *
 * 학번 구간 [A, B]가 주어졌을 때 이 학생들 성적의 평균을 구하는 프로그램을 작성하라.
 *
 * 제약조건
 * 1 ≤ N ≤ 106 인 정수
 *
 * 1 ≤ K ≤ 104 인 정수
 *
 * 1 ≤ Si ≤ 100 인 정수
 *
 * 1 ≤ Ai ≤ Bi ≤ N
 *
 * 입력형식
 * 첫 번째 줄에 학생 수 N과 구간 수 K가 주어진다.
 *
 * 두 번째 줄에는 학생의 성적 Si (1 ≤ i ≤ N)가 주어진다. i + 2 (1 ≤ i ≤ K)번째 줄에는 i번째 구간 Ai, Bi가 주어진다.
 *
 * 출력형식
 * i번째 줄에 i번째 구간의 성적평균(소수셋째자리에서 반올림)을 출력한다.
 *
 * 차이가 0.01이하이면 정답으로 채점됨.
 *
 * 5 3
 * 10 50 20 70 100
 * 1 3
 * 3 4
 * 1 5
 *
 * 26.67
 * 45.00
 * 50.00
 *
 */

import java.util.*;
import java.io.*;

public class Solution1 {

    private static int N;
    private static int K;
    private static int[] array;
    private static float[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        array = new int[N];
        result = new float[K];

        StringTokenizer tokenizer1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(tokenizer1.nextToken());
        }

        StringTokenizer tokenizer2;
        for (int i = 0; i < K; i++) {
            tokenizer2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tokenizer2.nextToken());
            int b = Integer.parseInt(tokenizer2.nextToken());

            int sum = 0;
            for (int j = a - 1; j < b; j++) {
                sum += array[j];
            }

            result[i] = sum / (float) (b - a + 1);
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(String.format("%.2f", result[i]));
        }
    }
}

