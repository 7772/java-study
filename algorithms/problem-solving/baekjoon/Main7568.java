import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;

public class Main7568 {

    private static int N;
    private static int[] height;
    private static int[] weight;
    private static Integer[] answer;
    private static Integer[] sortedAnswer;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        weight = new int[N];
        height = new int[N];
        answer = new Integer[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer input = new StringTokenizer(bf.readLine(), " ");
            weight[i] = Integer.parseInt(input.nextToken());
            height[i] = Integer.parseInt(input.nextToken());
        }

        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            answer[i] = getCount(i);
        }

        sortedAnswer = new Integer[N];
        sortedAnswer = answer.clone();
        Arrays.sort(sortedAnswer, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            System.out.print(getOrder(answer[i]) + " ");
        }
    }

    private static int getOrder(int value) {
        int index = 0;

        for (int i = 0; i < N; i++) {
            if (value == sortedAnswer[i]) {
                index = i + 1;
                break;
            }
        }

        return index;
    }

    private static int getCount(int current) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (height[current] > height[i] && weight[current] > weight[i]) {
                count++;
            }
        }

        return count;
    }
}
