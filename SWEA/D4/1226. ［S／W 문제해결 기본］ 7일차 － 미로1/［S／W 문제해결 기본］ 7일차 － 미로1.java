import java.io.*;
import java.util.*;

public class Solution {

	static final int T = 10;
	static final int SIZE = 16;
	static int result;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int tc = 1; tc <= T; tc++) {
			int t = Integer.parseInt(br.readLine());
			board = new int[SIZE][SIZE];
			visited = new boolean[SIZE][SIZE];
			result = 0;

			for (int i = 0; i < SIZE; i++) {
				String input = br.readLine();
				for (int j = 0; j < SIZE; j++) {
					board[i][j] = input.charAt(j) - '0';
					if (board[i][j] == 1) {
						visited[i][j] = true;
					}
				}
			}

			dfs(1, 1);
			// System.out.println("board = " + Arrays.deepToString(board));
			bw.write("#" + t + " " + result + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

	private static void dfs(final int x, final int y) {
		if (board[x][y] == 3) {
			result = 1;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny);
				visited[nx][ny] = false;
			}
		}
	}
}
