import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int n;
	static char[][] board;
	static String result;

	static int[] dx = {0, 1, 1, 1};
	static int[] dy = {1, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			board = new char[n][n];

			for (int i = 0; i < n; i++) {
				String line = br.readLine();

				for (int j = 0; j < n; j++) {
					board[i][j] = line.charAt(j);
				}
			}

			result = "NO";
			if (solve()) {
				result = "YES";
			}

			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static boolean solve() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'o') {
					for (int d = 0; d < 4; d++) {
						if (isFive(i, j, d)) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	private static boolean isFive(int i, int j, int d) {
		for (int k = 1; k < 5; k++) {
			int nx = i + dx[d] * k;
			int ny = j + dy[d] * k;

			if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] != 'o') {
				return false;
			}
		}

		return true;
	}

}
