import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.lang.Math;
import java.util.StringTokenizer;

public class Main9663 {

    private static int N;
    private static int[] array;
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        array = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    private static void nQueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            array[depth] = i;

            if (isPossible(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    private static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            if (array[col] == array[i]) {
                return false;
            }

            else if (Math.abs(col - i) == Math.abs(array[col] - array[i])) {
                return false;
            }
        }

        return true;
    }
}
