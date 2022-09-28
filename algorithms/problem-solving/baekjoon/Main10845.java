import java.io.*;
import java.util.*;

public class Main10845 {

    private static int size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        Queue queue = new Queue(size);

        StringTokenizer tokenizer;
        for (int i = 0; i < size; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            String command = tokenizer.nextToken();

            if ("push".equals(command)) {
                int x = Integer.parseInt(tokenizer.nextToken());
                queue.push(x);
            } else if ("pop".equals(command)) {
                System.out.println(queue.pop());
            } else if ("size".equals(command)) {
                System.out.println(queue.size());
            } else if ("empty".equals(command)) {
                System.out.println(queue.empty());
            } else if ("front".equals(command)) {
                System.out.println(queue.front());
            } else if ("back".equals(command)) {
                System.out.println(queue.back());
            }
        }

    }

    static class Queue {
        private static int[] data;
        private static int lastIndex;

        public Queue(int size) {
            this.data = new int[size];

            for (int i = 0; i < size; i++) {
                this.data[i] = -1;
            }

            this.lastIndex = 0;
        }

        public void push(int x) {
            data[lastIndex] = x;
            lastIndex++;
        }

        public int pop() {
            int first = data[0];

            for (int i = 1; i < data.length; i++) {
                data[i - 1] = data[i];
                data[i] = -1;
            }

            if (lastIndex > 0) {
                lastIndex--;
            }

            return first;
        }

        public int size() {
            return lastIndex;
        }

        public int empty() {
            return lastIndex > 0 ? 0 : 1;
        }

        public int front() {
            return data[0];
        }

        public int back() {
            return lastIndex > 0 ? data[lastIndex - 1] : -1;
        }
    }

}
