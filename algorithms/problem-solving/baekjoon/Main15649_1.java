import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15649_1 {

    private static int N;
    private static int M;

    private static int[] nodeArray;
    private static boolean[] visits;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        nodeArray = new int[N];
        visits = new boolean[N];

        for (int i = 0; i < N; i++) {
            visits[i] = false;
        }

        solve(0);
    }

    private static void solve(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(nodeArray[i] + 1 + " ");
            }

            System.out.println("");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visits[i]) {
                visits[i] = true;
                nodeArray[depth] = i;
                solve(depth + 1);
                visits[i] = false;
            }
        }
    }
}
