import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14501 {

    private static int N;
    private static int[] t;
    private static int[] p;
    private static boolean[] visits;

    private static int max = 0;
    private static int sum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        t = new int[N];
        p = new int[N];
        visits = new boolean[N];

        // 방문 노드 초기화
        for (int i = 0; i < N; i++) {
            visits[i] = true;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            t[i] = Integer.parseInt(tokenizer.nextToken());
            p[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dfs(i);
            sum = 0;
            for (int j = i; j < N; j++) {
                visits[j] = true;
            }
        }

        System.out.println(max);
    }

    private static void dfs(int index) {
        if (t[index] + index > N) {
            return;
        }

        // 방문 후 금액 더하기
        sum += p[index];
        max = max < sum ? sum : max;

        int temp = index;
        for (int i = 0; i < t[index]; i++) {
            if (temp + 1 <= N) {
                visits[temp++] = false;
            }
        }

        for (int i = index; i < N; i++) {
            if (visits[i]) {
                dfs(i);
                for (int j = i; j < N; j++) {
                    visits[j] = true;
                }
            }
        }

        sum -= p[index];
    }
}
