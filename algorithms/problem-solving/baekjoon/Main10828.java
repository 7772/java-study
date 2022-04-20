import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Integer;

public class Main10828 {

    private static int N;
    private static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        answer = new int[N];

        Stack stack = new Stack(N);
        StringTokenizer input;
        int k = 0;

        while (N > 0) {
            input = new StringTokenizer(bf.readLine(), " ");
            String command = input.nextToken();

            switch (command) {
                case "push":
                    int n = Integer.parseInt(input.nextToken());
                    stack.push(n);

                    break;
                case "pop":
                    answer[k++] = stack.pop();

                    break;
                case "size":
                    answer[k++] = stack.size();

                    break;
                case "top":
                    answer[k++] = stack.top();

                    break;
                case "empty":
                    answer[k++] = stack.empty();

                    break;
            }

            N--;
        }

        for (int i = 0; i < k; i++) {
            System.out.println(answer[i]);
        }
    }

    static class Stack {
        private int[] array;
        private int head;

        public Stack(int size) {
            this.array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = -1;
            }

            this.head = 0;
        }

        public void push(int n) {
            array[this.head++] = n;
        }

        public int pop() {
            if (this.head <= 0) {
                return -1;
            }

            int head = array[this.head - 1];
            array[this.head - 1] = -1;
            this.head--;

            return head;
        }

        public int size() {
            int size = 0;

            for (int i = 0; i < head; i++) {
                if (i != -1) {
                    size++;
                }
            }

            return size;
        }

        public int empty() {
            return size() == 0 ? 1 : 0;
        }

        public int top() {
            if (head > 0) {
                return array[head - 1];
            } else {
                return array[head];
            }
        }
    }
}
