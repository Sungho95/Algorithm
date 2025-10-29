import java.io.*;
import java.util.*;

public class Solution {

    static int n;
    static int k;
    static int[][] board;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            board = new int[n][n];
            result = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1) {
                        count++;
                    } else {
                        if (count == k) {
                            result++;
                        }
                        count = 0;
                    }
                }

                if (count == k) {
                    result++;
                }
            }

            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (board[j][i] == 1) {
                        count++;
                    } else {
                        if (count == k) {
                            result++;
                        }
                        count = 0;
                    }
                }

                if (count == k) {
                    result++;
                }
            }

            bw.write("#" + tc + " " + result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
