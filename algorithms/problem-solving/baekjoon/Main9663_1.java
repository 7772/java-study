import java.io.*;
import java.util.*;

public class Main9663_1 {

    private static int N;
    private static int[] array;
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

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
            // 행이 같은지
            if (array[col] == array[i]) {
                return false;
            }

            // 대각이 같은지
            if (Math.abs(col - i) == Math.abs(array[col] - array[i])) {
                return false;
            }
        }

        return true;
    }
}
