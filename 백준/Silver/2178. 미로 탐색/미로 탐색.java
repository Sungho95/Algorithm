import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int m;
	static boolean[][] visited;
	static int[][] matrix;

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		matrix = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				matrix[i][j] = line.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);

		bw.write(String.valueOf(matrix[n - 1][m - 1]));
		br.close();
		bw.flush();
		bw.close();
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (matrix[nx][ny] != 0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						matrix[nx][ny] = matrix[x][y] + 1;
						queue.offer(new int[] {nx, ny});
					}
				}
			}
		}
	}
}
