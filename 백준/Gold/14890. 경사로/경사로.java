import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int l;
	static int[][] matrix;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();

		for (int i = 0; i < n; i++) {
			if (isPossibleRow(i)) {
				result++;
			}

			if (isPossibleCol(i)) {
				result++;
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	private static boolean isPossibleRow(int row) {
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n - 1; i++) {
			int diff = matrix[row][i] - matrix[row][i + 1];
			if (diff == 0) {
				continue;
			} else if (diff == -1) { // 높아지는 경우
				for (int j = 0; j < l; j++) {
					// 범위를 벗어나거나 이미 방문했거나, l개만큼 연속적으로 같지 않을 경우 false
					if (i - j < 0 || visited[i - j] || matrix[row][i] != matrix[row][i - j]) {
						return false;
					}

					// 경사로 설치
					visited[i - j] = true;
				}
			} else if (diff == 1) { // 낮아지는 경우
				for (int j = 1; j <= l; j++) {
					// 범위를 벗어나거나 이미 방문했거나, l개만큼 연속적으로 같지 않을 경우 false
					if (i + j >= n || visited[i + j] || matrix[row][i] - 1 != matrix[row][i + j]) {
						return false;
					}
					visited[i + j] = true;
				}
			} else {
				return false;
			}
		}

		return true;
	}

	private static boolean isPossibleCol(int col) {
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n - 1; i++) {
			int diff = matrix[i][col] - matrix[i + 1][col];

			if (diff == 0) {
				continue;
			} else if (diff == -1) { // 높아지는 경우
				for (int j = 0; j < l; j++) {
					if (i - j < 0 || visited[i - j] || matrix[i][col] != matrix[i - j][col]) {
						return false;
					}
					visited[i - j] = true;
				}
			} else if (diff == 1) { // 낮아지는 경우
				for (int j = 1; j <= l; j++) {
					if (i + j >= n || visited[i + j] || matrix[i][col] - 1 != matrix[i + j][col]) {
						return false;
					}
					visited[i + j] = true;
				}
			} else {
				return false;
			}
		}

		return true;
	}
}
