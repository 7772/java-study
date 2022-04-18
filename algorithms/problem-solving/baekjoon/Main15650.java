import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.util.StringTokenizer;

public class Main15650 {

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

        dfs(0, 0);
    }

    public static void dfs(int start, int depth) {
        if (depth == M) {
            for (int i : array) {
                System.out.print(i + " ");
            }

            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            array[depth] = i + 1;
            dfs(i + 1, depth + 1);
        }
    }
}
