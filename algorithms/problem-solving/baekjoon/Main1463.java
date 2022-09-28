import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1463 {

    private static int N;
    private static Integer[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        dp[0] = 0;
        dp[1] = 0;

        System.out.println(solution(N));
    }

    private static int solution(int n) {
        if (dp[n] == null) {
            if (n % 6 == 0) {
                dp[n] = Math.min(solution(n / 3), Math.min(solution(n / 2), solution(n - 1))) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(solution(n / 3), solution(n - 1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(solution(n / 2), solution(n - 1)) + 1;
            } else {
                dp[n] = solution(n - 1) + 1;
            }
        }

        return dp[n];
    }
}
