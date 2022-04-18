import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.util.StringTokenizer;

public class Main15649 {

    private static int N;
    private static int M;
    private static int[] array;
    private static boolean[] visits;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(input.nextToken());
        M = Integer.parseInt(input.nextToken());

        array = new int[M];
        visits = new boolean[N];

        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(array[i] + " ");
            }

            System.out.println();

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visits[i]) {
                visits[i] = true;
                array[depth] = i + 1;
                dfs(depth + 1);
                visits[i] = false;
            }
        }
    }
}
