import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Solution {

    private static int N;
    private static boolean[] visits;
    private static int[] D0;
    private static int[] d;
    private static int[] score;
    private static int scoreSum = 0;
    private static int dSum = 0;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        D0 = new int[N];
        d = new int[N];
        score = new int[N];
        visits = new boolean[200];

        StringTokenizer tokenizer;
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");

            D0[i] = Integer.parseInt(tokenizer.nextToken());
            d[i] = Integer.parseInt(tokenizer.nextToken());
            score[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dfs(i);
            scoreSum = 0;
            dSum = 0;

            for (int j = i; j < 200; j++) {
                visits[j] = true;
            }
        }

        System.out.println(max);
    }

    private static void dfs(int index) {
        if (index == N) {
            return;
        }

        // 탈출 조건
        dSum += d[index];

        if (index > 0 && (dSum > 200 || (D0[index] + dSum > 200) || (D0[index] < dSum))) {
            return;
        }


        System.out.println(">> " + index + " " + D0[index] + " " + score[index]);

        // 금액 합
        scoreSum += score[index];
        max = max < scoreSum ? scoreSum : max;

        // 방문 처리
        int temp = D0[index];
        for (int i = 0; i < d[index]; i++) {
            visits[temp++] = false;
        }

        // dfs 탐색
        for (int i = 0; i < 200; i++) {
            if (visits[i]) {
                dfs(index + 1);
                for (int j = i; j < 200; j++) {
                    visits[j] = true;
                }
            }
        }

        scoreSum -= score[index];
    }
}
