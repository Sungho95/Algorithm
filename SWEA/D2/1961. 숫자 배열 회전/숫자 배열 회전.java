import java.io.*;
import java.util.*;

public class Solution {

    static int n;
    static int[][] board;
    static String[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb;

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            result = new String[n][3];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            // 90도
            for (int i = 0; i < n; i++) {
                sb = new StringBuilder();
                for (int j = n - 1; j >= 0; j--) {
                    sb.append(board[i][j]);
                }

                result[i][0] = sb.toString();
            }

            // 180도
            for (int i = 0; i < n; i++) {
                sb = new StringBuilder();
                for (int j = n - 1; j >= 0; j--) {
                    sb.append(board[j][n - 1 - i]);
                }

                result[i][1] = sb.toString();
            }

            // 270도
            for (int i = 0; i < n; i++) {
                sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[n - 1 - i][j]);
                }

                result[i][2] = sb.toString();
            }

            bw.write("#" + tc + "\n");
            for (int i = 0; i < n; i++) {
                bw.write(result[i][0] + " " + result[i][1] + " " + result[i][2] + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
