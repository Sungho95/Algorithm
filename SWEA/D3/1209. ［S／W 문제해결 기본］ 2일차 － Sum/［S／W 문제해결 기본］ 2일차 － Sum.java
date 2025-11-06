import java.io.*;
import java.util.*;

public class Solution {

    static final int SIZE = 100;

    static int t;
    static int[][] board;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            t = Integer.parseInt(br.readLine());
            sum = Integer.MIN_VALUE;

            board = new int[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < SIZE; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 행
            int temp;
            for (int i = 0; i < SIZE; i++) {
                temp = 0;
                for (int j = 0; j < SIZE; j++) {
                    temp += board[i][j];
                }
                sum = Math.max(sum, temp);
            }

            // 열
            for (int i = 0; i < SIZE; i++) {
                temp = 0;
                for (int j = 0; j < SIZE; j++) {
                    temp += board[j][i];
                }
                sum = Math.max(sum, temp);
            }

            // 대각
            temp = 0;
            for (int i = 0; i < SIZE; i++) {
                temp += board[i][i];
            }
            sum = Math.max(sum, temp);

            temp = 0;
            for (int i = 0; i < SIZE; i++) {
                temp += board[SIZE - i - 1][i];
            }
            sum = Math.max(sum, temp);

            bw.write("#" + tc + " " + sum + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
