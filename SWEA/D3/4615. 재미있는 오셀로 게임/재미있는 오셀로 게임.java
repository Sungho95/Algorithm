import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int n;
	static int m;
	static int[][] board;
	static int black;
	static int white;

	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			board = new int[n][n];

			board[n / 2 - 1][n / 2 - 1] = 2;
			board[n / 2][n / 2 - 1] = 1;
			board[n / 2 - 1][n / 2] = 1;
			board[n / 2][n / 2] = 2;

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int z = Integer.parseInt(st.nextToken());

				board[x][y] = z;

				for (int j = 0; j < 8; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];

					boolean check = false;
					while (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] != 0) {
						if (board[nx][ny] == z) {
							check = true;
							break;
						}

						nx += dx[j];
						ny += dy[j];
					}

					if (check) {
						int tx = x + dx[j];
						int ty = y + dy[j];

						while (tx != nx || ty != ny) {
							board[tx][ty] = z;
							tx += dx[j];
							ty += dy[j];
						}
					}
				}
			}

			black = 0;
			white = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 1) {
						black++;
					} else if (board[i][j] == 2) {
						white++;
					}
				}
			}

			bw.write("#" + tc + " " + black + " " + white + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
