import java.io.*;
import java.util.*;

public class Main15988 {

    private static int MAX = 1_000_001;
    private static int N;
    private static long[] dp = new long[MAX];
    private static long[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < MAX; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }

        answer = new long[N];

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            answer[i] = dp[n];
        }

        for (int i = 0; i < N; i++) {
            System.out.println(answer[i]);
        }
    }
}
