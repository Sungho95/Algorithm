import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int m;
	static int[][] matrix;
	static int r;
	static int c;
	static int d;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int result;

	// d : 0 = 북, 1 = 동, 2 = 남, 3 = 서
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();

		result = 1;

		solve(r, c, d);

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	public static void solve(int r, int c, int d) {
		// 청소
		matrix[r][c] = -1;

		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4;
			int nr = r + dy[d];
			int nc = c + dx[d];

			if (nr >= 0 && nr < n && nc >= 0 && nc < m && matrix[nr][nc] == 0) {
				result++;
				solve(nr, nc, d);
				return;
			}
		}

		int back = (d + 2) % 4;
		int nr = r + dy[back];
		int nc = c + dx[back];

		if (nr >= 0 && nr < n && nc >= 0 && nc < m && matrix[nr][nc] != 1) {
			solve(nr, nc, d);
		}
	}
}
