import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int n;
	static char[][] board;
	static int[][] mineCounts;
	static boolean[][] visited;
	static int result;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			board = new char[n][n];
			mineCounts = new int[n][n];
			visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				board[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == '.') {
						int count = 0;
						for (int d = 0; d < 8; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == '*') {
								count++;
							}
						}
						mineCounts[i][j] = count;
					}
				}
			}

			result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == '.' && mineCounts[i][j] == 0 && !visited[i][j]) {
						result++;
						bfs(i, j);
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == '.' && !visited[i][j]) {
						result++;
					}
				}
			}

			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		visited[i][j] = true;

		while (!q.isEmpty()) {
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];

			for (int d = 0; d < 8; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && board[nx][ny] == '.') {
					visited[nx][ny] = true;

					if (mineCounts[nx][ny] == 0) {
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
	}

}
