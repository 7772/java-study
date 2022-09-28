import java.io.*;
import java.util.*;

public class Solution2 {
    private static String message;
    private static LinkedList<String> messageList; // [ "A", "B", "C", "C" .. ]

    private static String key;
    private static LinkedHashSet<String> keyHashSet; // { "A", "B", "C" } 중복제거

    private static char[] alphabets;
    private static char[][] matrix = new char[5][5];

    private static StringBuilder result = new StringBuilder("");

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        message = br.readLine();
        messageList = new LinkedList<>();

        key = br.readLine();
        keyHashSet = new LinkedHashSet<>(Arrays.asList(key.split("")));
        alphabets = new char[26];

        makeMatrix();
        makeMessageList();
        encrypt();
        System.out.println(result.toString());
    }

    private static void encrypt() {
        StringBuilder verticalString = new StringBuilder("");

        for (String key : messageList) {
            boolean horizontalMatched = false;
            boolean verticalMatched = false;

            for (int i = 0; i < matrix.length; i++) {

//                System.out.println(matrix[i]);
//                System.out.println(key);

                if (String.valueOf(matrix[i]).contains(String.valueOf(key.charAt(0))) &&
                        String.valueOf(matrix[i]).contains(String.valueOf(key.charAt(1)))) {
                    // 1번 매칭
                    int first = String.valueOf(matrix[i]).indexOf(String.valueOf(key.charAt(0))) + 1;
                    int second = String.valueOf(matrix[i]).indexOf(String.valueOf(key.charAt(1))) + 1;

                    if (first >= matrix[i].length) {
                        first = 0;
                    }

                    if (second >= matrix[i].length) {
                        second = 0;
                    }

                    result.append(matrix[i][first]);
                    result.append(matrix[i][second]);

                    horizontalMatched = true;
                    break;
                }
            }

            if (horizontalMatched) {
                continue;
            }

            for (int i = 0; i < matrix.length; i++) {
                verticalString.setLength(0);

                for (int j = 0; j < matrix.length; j++) {
                    verticalString.append(String.valueOf(matrix[j][i]));
                }

//                System.out.println("-> verticalString : " + verticalString.toString() + " " + key);
//                System.out.println("-> matched : " + verticalString.toString().contains(String.valueOf(key.charAt(0))) + " " + verticalString.toString().contains(String.valueOf(key.charAt(1))));

                if (verticalString.toString().contains(String.valueOf(key.charAt(0))) &&
                    verticalString.toString().contains(String.valueOf(key.charAt(1)))) {
                    int first = verticalString.toString().indexOf(String.valueOf(key.charAt(0))) + 1;
                    int second = verticalString.toString().indexOf(String.valueOf(key.charAt(1))) + 1;

                    if (first >= matrix[i].length) {
                        first = 0;
                    }

                    if (second >= matrix[i].length) {
                        second = 0;
                    }

                    result.append(matrix[first][i]);
                    result.append(matrix[second][i]);

                    verticalMatched = true;
                    break;
                }
            }

            if (verticalMatched) {
                continue;
            }

            if (!horizontalMatched && !verticalMatched) {
                int xI = -1;
                int xJ = -1;
                int yI = -1;
                int yJ = -1;

                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length; j++) {
//                        System.out.println(key);
                        if (matrix[i][j] == key.charAt(0)) {
                            xI = i;
                            xJ = j;
                        } else if (matrix[i][j] == key.charAt(1)) {
                            yI = i;
                            yJ = j;
                        }
                    }

                    if (xJ > -1 && yJ > -1) {
                        break;
                    }
                }

//                System.out.println("KEY x : " + xI + " " + xJ);
//                System.out.println("KEY y : " + yI + " " + yJ);
//
//                System.out.println("append x : " + matrix[xI][yJ]);
//                System.out.println("append y : " + matrix[yI][xJ]);

                result.append(matrix[xI][yJ]);
                result.append(matrix[yI][xJ]);
            }
        }
    }

    private static void makeMatrix() {
        int alphaCount = 0;
        for (int i = 0; i < 26; i++) {
            // J는 제외
            if (65 + i == 74) {
                continue;
            }

            alphabets[alphaCount++] = (char) (65 + i);
        }

        for (String key : keyHashSet) {
            for (int i = 0; i < alphabets.length; i++) {
                if (key.equals(String.valueOf(alphabets[i]))) {
                    alphabets[i] = '-';
                }
            }
        }

        int i = 0;
        int j = 0;
        for (String key : keyHashSet) {
            if (j >= 5) {
                j = 0;
                i++;
            }

            matrix[i][j] = key.charAt(0);
            j++;
        }

        for (int k = 0; k < alphabets.length; k++) {
            if (j >= 5) {
                j = 0;
                i++;
            }

            if (i >= 5) {
                break;
            }

            if (alphabets[k] != '-') {
                matrix[i][j] = alphabets[k];
                j++;
            }
        }

//        for (int k = 0; k < 5; k++) {
//            for (int l = 0; l < 5; l++) {
//                System.out.print(matrix[k][l] + " ");
//            }
//            System.out.println("");
//        }
    }

    private static void makeMessageList() {
        StringBuilder sb = new StringBuilder(message);

        while (true) {
            boolean infinity = true;

            for (int i = 0; i < sb.length(); i = i + 2) {
                int len = i + 2;

                if (len > sb.length()) {
                    len = sb.length();
                }

                String term = sb.toString().substring(i, len);
                if (term.length() >= 2 && term.charAt(0) == term.charAt(1)) {
                    String key = term.charAt(0) == 'X' ? "Q" : "X";
                    sb.insert(i + 1, key);
                    break;
                } else {
                    infinity = false;
                }
            }

            if (!infinity) {
                if (sb.length() % 2 == 1) {
                    String key = sb.charAt(sb.length() - 1) == 'X' ? "Q" : "X";
                    sb.append(key);
                }

                break;
            }
        }

        for (int i = 0; i < sb.length(); i = i + 2) {
            int len = i + 2;

            if (len > sb.length()) {
                len = sb.length();
            }

            messageList.add(sb.toString().substring(i, len));
        }

//        for (String key : messageList) {
//            System.out.println("!!! " + key);
//        }
    }
}



