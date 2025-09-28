import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int x; // 0 <= x <= 100
	static int y; // 0 <= y <= 100
	static int d; // 0 <= d <= 3 (0 = 우, 1 = 상, 2 = 좌, 3 = 하)
	static int g; // 0 <= g <= 10
	static int result = 0;
	static boolean[][] matrix = new boolean[101][101];
	static List<Integer> dirList;

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		// 3 3 0 1
		// 4 2 1 3
		// 4 2 2 1
		// 2 7 3 4
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());

			dirList = new ArrayList<>();
			addDirList(d, g);
			dragon(x, y);
		}
		br.close();
		check();
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	private static void addDirList(int d, int g) {
		dirList.add(d);

		for (int i = 1; i <= g; i++) {
			for (int j = dirList.size() - 1; j >= 0; j--) {
				dirList.add((dirList.get(j) + 1) % 4);
			}
		}
	}

	private static void dragon(int x, int y) {
		matrix[x][y] = true;

		int nx = x;
		int ny = y;
		for (int d : dirList) {
			nx += dx[d];
			ny += dy[d];

			matrix[nx][ny] = true;
		}
	}

	private static void check() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (matrix[i][j] && matrix[i + 1][j] && matrix[i][j + 1] && matrix[i + 1][j + 1]) {
					result++;
				}
			}
		}
	}
}
