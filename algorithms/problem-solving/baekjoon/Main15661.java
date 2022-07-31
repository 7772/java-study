import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15661 {

    private static int N;
    private static int[][] array;
    private static boolean[] visits;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        array = new int[N][N];
        visits = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    private static void dfs(int index, int depth) {
        if (depth >= 1) {
            calc();
        }

        if (depth >= N - 1) {
            return;
        }

        // 1팀만 검사하는 경우를 포함해야 하므로 0 부터 검사
        for (int i = index; i < N; i++) {
            if (!visits[i]) {
                visits[i] = true;
                dfs(i + 1, depth + 1);
                visits[i] = false;
            }
        }
    }

    private static void calc() {
        int s = 0;
        int r = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visits[i] && visits[j]) {
                    // s team
                    s += array[i][j] + array[j][i];
                } else if (!visits[i] && !visits[j]) {
                    // r team
                    r += array[i][j] + array[j][i];
                }
            }
        }

        int result = Math.abs(s - r);
        min = min < result ? min : result;
    }
}
