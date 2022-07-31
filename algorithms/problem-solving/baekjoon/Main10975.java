import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main10975 {

    private static int N;
    private static int[] array;
    private static boolean[] visits;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visits = new boolean[N];

        for (int i = 0; i < N; i++) {
            visits[i] = false;
        }

        array = new int[N];

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(array[i] + 1 + " ");
            }

            System.out.println("");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visits[i]) {
                visits[i] = true;
                array[depth] = i;
                dfs(depth + 1);
                visits[i] = false;
            }
        }
    }
}
