import java.io.*;
import java.util.*;

public class Solution {

	static final int T = 10;
	static int n;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int deadLockCount = 0;
			for (int col = 0; col < n; col++) { // 1 : N극
				boolean flag = false;

				for (int row = 0; row < n; row++) {
					int num = board[row][col];

					if (num == 1) {
						flag = true;
					} else if (num == 2) {
						if (flag) {
							deadLockCount++;
							flag = false;
						}
					}
				}
			}

			bw.write("#" + tc + " " + deadLockCount + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
