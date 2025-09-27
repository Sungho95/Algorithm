import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int m;
	static int[][] room;
	static int[][] visited;
	static int result = Integer.MAX_VALUE;
	static List<CCTV> cctvList = new ArrayList<>();
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][][] cctvDirection = {
		{{0}, {1}, {2}, {3}},
		{{0, 2}, {1, 3}},
		{{0, 1}, {1, 2}, {2, 3}, {3, 0}},
		{{3, 0, 1}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}},
		{{0, 1, 2, 3}}
	};

	static class CCTV {
		int x;
		int y;
		int type;

		public CCTV(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		room = new int[n][m];
		visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());

				if (room[i][j] != 0) {
					if (room[i][j] != 6) {
						cctvList.add(new CCTV(i, j, room[i][j] - 1));
					}
				}
			}
		}
		br.close();

		solve(0);
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	private static void solve(int count) {
		if (count == cctvList.size()) {
			int blind = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (room[i][j] == 0 && visited[i][j] == 0) {
						blind++;
					}
				}
			}
			result = Math.min(result, blind);
			return;
		}

		CCTV cctv = cctvList.get(count);
		int type = cctv.type;
		for (int i = 0; i < cctvDirection[type].length; i++) {
			watch(cctv, cctvDirection[type][i], 1);
			solve(count + 1);
			watch(cctv, cctvDirection[type][i], -1);
		}
	}

	private static void watch(CCTV cctv, int[] directions, int visit) {
		for (int i = 0; i < directions.length; i++) {
			int nx = cctv.x + dx[directions[i]];
			int ny = cctv.y + dy[directions[i]];

			while (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] != 6) {
				if (room[nx][ny] == 0) {
					visited[nx][ny] += visit;
				}

				nx += dx[directions[i]];
				ny += dy[directions[i]];
			}
		}
	}
}
