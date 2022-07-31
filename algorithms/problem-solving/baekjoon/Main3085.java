import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main3085 {

    private static int N;
    private static char[][] charArray;

    private static int cCount = 0;
    private static int pCount = 0;
    private static int zCount = 0;
    private static int yCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        charArray = new char[N][N];

        for (int i = 0; i < N; i++) {
            charArray[i] = br.readLine().toCharArray();
        }

        solve();
    }

    private static void solve() {
        int max = 0;

        for (int i = 0; i < N; i++) {
            int _max = 0;

            for (int j = 0; j < N; j++) {
                int currentCount = 0;
                int rightCount = 0;
                int leftCount = 0;
                int belowCount = 0;
                int aboveCount = 0;

                // 자기 자신
                currentCount = countMatchedColor(i, j, charArray[i][j], "Current");
                if (_max < currentCount) {
                    _max = currentCount;
                }

                // 오른쪽과 교환
                if (j < N - 1) {
                    rightCount = countMatchedColor(i, j, charArray[i][j + 1], "Right");
                    if (_max < rightCount) {
                        _max = rightCount;
                    }
                }

                // 왼쪽과 교환
                if (j > 1) {
                    leftCount = countMatchedColor(i, j, charArray[i][j - 1], "Left");
                    if (_max < leftCount) {
                        _max = leftCount;
                    }
                }

                // 아래 교환
                if (i < N - 1) {
                    belowCount = countMatchedColor(i, j, charArray[i + 1][j], "Below");
                    if (_max < belowCount) {
                        _max = belowCount;
                    }
                }

                // 위 교환
                if (i > 1) {
                    aboveCount = countMatchedColor(i, j, charArray[i - 1][j], "Above");
                    if (_max < aboveCount) {
                        _max = aboveCount;
                    }
                }
            }

            if (_max > max) {
                max = _max;
            }
        }

        System.out.println(max);
    }

    private static int countMatchedColor(int x, int y, char color, String direct) {
        char[][] copiedArray = swapAndCopy(x, y, direct);

        int xCount = 0;
        int yCount = 0;

        boolean isMathedOverFirstLoop = false;

        // 세로 일치 여부 계산
        for (int i = 0; i < N; i++) {
            if (color == copiedArray[i][y]) {
                if (i < 1) {
                    yCount++;
                } else {
                    if (copiedArray[i][y] == copiedArray[i - 1][y]) {
                        yCount++;
                        isMathedOverFirstLoop = true;
                    }
                }
            }


            if (yCount >= N) {
                return yCount;
            }
        }

        // 가로 일치 여부 계산
        for (int i = 0; i < N; i++) {
            if (color == copiedArray[x][i]) {
                if (i < 1) {
                    xCount++;
                } else {
                    if (copiedArray[x][i] == copiedArray[x][i - 1]) {
                        xCount++;
                        isMathedOverFirstLoop = true;
                    }
                }
            }


            if (xCount >= N) {
                return xCount;
            }
        }

        int result = xCount > yCount ? xCount : yCount;

        return isMathedOverFirstLoop ? result + 1 : result;
    }

    private static char[][] swapAndCopy(int x, int y, String direction) {
        char[][] copiedArray = new char[N][N];

        for (int i = 0; i < N; i++) {
            copiedArray[i] = Arrays.copyOf(charArray[i], N);
        }

        char temp = copiedArray[x][y];

        if (direction == "Right") {
            copiedArray[x][y] = copiedArray[x][y + 1];
            copiedArray[x][y + 1] = temp;
        } else if (direction == "Left") {
            copiedArray[x][y] = copiedArray[x][y - 1];
            copiedArray[x][y - 1] = temp;
        } else if (direction == "Above") {
            copiedArray[x][y] = copiedArray[x - 1][y];
            copiedArray[x - 1][y] = temp;
        } else if (direction == "Below") {
            copiedArray[x][y] = copiedArray[x + 1][y];
            copiedArray[x + 1][y] = temp;
        }

        return copiedArray;
    }
}
