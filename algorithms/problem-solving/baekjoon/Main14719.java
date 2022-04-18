
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Main14719 {

    private static Scanner scanner = new Scanner(System.in);
    private static int[][] WALLS;
    private static int ROW;
    private static int COLUMN;
    private static int EMPTY = 0;
    private static int OCCUPIED = 1;
    private static int WATER = 2;
    private static int COLUMN_INDEX_POSITION = -1;

    public static void main(String[] args) {
        ROW = scanner.nextInt();
        COLUMN = scanner.nextInt();

        WALLS = new int[ROW][COLUMN];

        for (int i = 0; i < COLUMN; i++) {
            int count = scanner.nextInt();
            int rowCount = ROW - 1;

            while (count > 0) {
                WALLS[rowCount][i] = OCCUPIED;

                rowCount--;
                count--;
            }
        }

        solve();
        print();
    }

    public static void solve() {
        for (int i = 1; i < COLUMN - 1; i++) {
            int min = Math.min(prevMax(i), getOccupiedCount(i + 1));
            if (min > 0) {
                water(i, min);
            }
        }
    }

    public static void water(int column, int max) {
        for (int i = COLUMN_INDEX_POSITION + 1; i <= column; i++) {
            for (int j = ROW - 1; j >= ROW - max; j--) {
                if (WALLS[j][i] != OCCUPIED) {
                    WALLS[j][i] = WATER;
                }
            }
        }
    }

    public static int prevMax(int i) {
        int max = 0;

        for (int j = 0; j <= i; j++) {
            int occupiedCount = getOccupiedCount(j);
            if (max < occupiedCount) {
                max = occupiedCount;
                COLUMN_INDEX_POSITION = j;
            }
        }

        return max;
    }

    public static int getOccupiedCount(int column) {
        int count = 0;

        for (int i = 0; i < ROW; i++) {
            if (WALLS[i][column] == OCCUPIED) {
                count++;
            }
        }

        return count;
    }

    public static void print() {
        int count = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (WALLS[i][j] == WATER) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
