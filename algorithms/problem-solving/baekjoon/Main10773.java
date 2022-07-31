import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10773 {

    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(bf.readLine());

            if (number != 0) {
                stack.push(number);
            } else {
                stack.pop();
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
