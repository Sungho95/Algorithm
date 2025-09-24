import java.io.*;
import java.util.*;

public class Main {
    static int[][] matrix;
    static long max = 0;
    static int n;
    static char[] directions = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        dfs(0);
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    private static void dfs(int count) {
        if (count == 5) {
            findMaxValue();
            return;
        }

        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, n);
        }

        for (char direction : directions) {
            moveAndSum(direction);
            dfs(count + 1);
            for (int i = 0; i < n; i++) {
                System.arraycopy(copy[i], 0, matrix[i], 0, n);
            }
        }
    }

    private static void moveAndSum(char direction) {
        move(direction);
        sum(direction);
        move(direction);
    }

    private static void move(char direction) {
        if (direction == 'U') { // 위로 이동
            for (int col = 0; col < n; col++) {
                int writePos = 0;
                for (int row = 0; row < n; row++) {
                    if (matrix[row][col] != 0) {
                        if (writePos != row) {
                            matrix[writePos][col] = matrix[row][col];
                            matrix[row][col] = 0;
                        }
                        writePos++;
                    }
                }
            }
        } else if (direction == 'D') { // 아래로 이동
            for (int col = 0; col < n; col++) {
                int writePos = n - 1;
                for (int row = n - 1; row >= 0; row--) {
                    if (matrix[row][col] != 0) {
                        if (writePos != row) {
                            matrix[writePos][col] = matrix[row][col];
                            matrix[row][col] = 0;
                        }
                        writePos--;
                    }
                }
            }
        } else if (direction == 'L') { // 왼쪽으로 이동
            for (int row = 0; row < n; row++) {
                int writePos = 0;
                for (int col = 0; col < n; col++) {
                    if (matrix[row][col] != 0) {
                        if (writePos != col) {
                            matrix[row][writePos] = matrix[row][col];
                            matrix[row][col] = 0;
                        }
                        writePos++;
                    }
                }
            }
        } else if (direction == 'R') { // 오른쪽으로 이동
            for (int row = 0; row < n; row++) {
                int writePos = n - 1;
                for (int col = n - 1; col >= 0; col--) {
                    if (matrix[row][col] != 0) {
                        if (writePos != col) {
                            matrix[row][writePos] = matrix[row][col];
                            matrix[row][col] = 0;
                        }
                        writePos--;
                    }
                }
            }
        }
    }

    private static void sum(char direction) {
        if (direction == 'U') {
            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n - 1; row++) {
                    if (matrix[row][col] == 0) continue;
                    if (matrix[row][col] == matrix[row + 1][col]) {
                        matrix[row][col] += matrix[row + 1][col];
                        matrix[row + 1][col] = 0;
                    }
                }
            }
        } else if (direction == 'D') {
            for (int col = 0; col < n; col++) {
                for (int row = n - 1; row >= 1; row--) {
                    if (matrix[row][col] == 0) continue;
                    if (matrix[row][col] == matrix[row - 1][col]) {
                        matrix[row][col] += matrix[row - 1][col];
                        matrix[row - 1][col] = 0;
                    }
                }
            }
        } else if (direction == 'L') {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n - 1; col++) {
                    if (matrix[row][col] == 0) continue;
                    if (matrix[row][col] == matrix[row][col + 1]) {
                        matrix[row][col] += matrix[row][col + 1];
                        matrix[row][col + 1] = 0;
                    }
                }
            }
        } else if (direction == 'R') {
            for (int row = 0; row < n; row++) {
                for (int col = n - 1; col >= 1; col--) {
                    if (matrix[row][col] == 0) continue;
                    if (matrix[row][col] == matrix[row][col - 1]) {
                        matrix[row][col] += matrix[row][col - 1];
                        matrix[row][col - 1] = 0;
                    }
                }
            }
        }
    }

    private static void findMaxValue() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
    }
}
