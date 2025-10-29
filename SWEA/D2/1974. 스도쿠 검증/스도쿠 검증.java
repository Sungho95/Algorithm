import java.io.*;
import java.util.*;

public class Solution {

    static int rowSum, colSum, sum;
    static int[][] board = new int[9][9];
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int tc = 1; tc <= t; tc++) {
            result = 1;
            // 스도쿠 보드
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 9; i++) {
                rowSum = 0;
                colSum = 0;
                for (int j = 0; j < 9; j++) {
                    rowSum += board[i][j];
                    colSum += board[j][i];
                }

                if (rowSum != 45 || colSum != 45) {
                    result = 0;
                    break;
                }
            }

            for (int i = 0; i < 9; i++) {
                int startRow = i / 3 * 3;
                int startCol = i % 3 * 3;
                sum = 0;

                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        sum += board[startRow + j][startCol + k];
                    }
                }

                if (sum != 45) {
                    result = 0;
                    break;
                }
            }

            bw.write("#" + tc + " " + result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
