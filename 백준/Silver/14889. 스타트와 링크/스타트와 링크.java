import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] matrix;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];
		visited = new boolean[n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			 st = new StringTokenizer(br.readLine());
			 for (int j = 0; j < n; j++) {
				 matrix[i][j] = Integer.parseInt(st.nextToken());
			 }
		}
		br.close();

		dfs(0, 0);

		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
	}

	private static void dfs(int count, int idx) {
		if (count == n / 2) {
			calculate();
			return;
		}

		for (int i = idx; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(count + 1, i + 1);
				visited[i] = false;
			}
		}
	}

	private static void calculate() {
		int teamStart =  0;
		int teamLink = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (visited[i] && visited[j]) {
					teamStart += matrix[i][j];
					teamStart += matrix[j][i];
				}

				if (!visited[i] && !visited[j]) {
					teamLink += matrix[i][j];
					teamLink += matrix[j][i];
				}
			}
		}

		min = Math.min(min, Math.abs(teamStart - teamLink));
	}
}
