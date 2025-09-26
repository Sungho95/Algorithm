import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int[][] matrix;
	static int result = Integer.MIN_VALUE;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		matrix = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	private static void dfs(int count) {
		if (count == 3) {
			bfs();
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][j] = 1;
					dfs(count + 1);
					matrix[i][j] = 0;
				}
			}
		}
	}

	private static void bfs() {
		int[][] clone = new int[n][m];
		for (int i = 0; i < n; i++) {
			clone[i] = matrix[i].clone();
		}

		Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 2) {
					queue.offer(new Node(i, j));
				}
			}
		}

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}

				if (clone[nx][ny] == 0) {
					clone[nx][ny] = 2;
					queue.offer(new Node(nx, ny));
				}
			}
		}

		int zero = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (clone[i][j] == 0) {
					zero++;
				}
			}
		}

		result = Math.max(result, zero);
	}

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
