import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int m;
	static char[][] map;
	static boolean[][][][] visited;
	static int result;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static class State {
		int rx;
		int ry;
		int bx;
		int by;
		int count;

		public State(int rx, int ry, int bx, int by, int count) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m][n][m];
		result = -1;

		int rx = 0;
		int ry = 0;
		int bx = 0;
		int by = 0;
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'R') {
					rx = i;
					ry = j;
				} else if (map[i][j] == 'B') {
					bx = i;
					by = j;
				}
			}
		}

		bfs(rx, ry, bx, by);

		bw.write(String.valueOf(result));
		br.close();
		bw.flush();
		bw.close();
	}

	private static void bfs(int rx, int ry, int bx, int by) {
		Queue<State> queue = new LinkedList<>();
		queue.offer(new State(rx, ry, bx, by, 0));
		visited[rx][ry][bx][by] = true;

		while (!queue.isEmpty()) {
			State current = queue.poll();

			if (current.count >= 10) {
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nrx = current.rx;
				int nry = current.ry;
				int nbx = current.bx;
				int nby = current.by;

				boolean redFlag = false;
				while (map[nrx + dx[i]][nry + dy[i]] != '#') {
					nrx += dx[i];
					nry += dy[i];

					if (map[nrx][nry] == 'O') {
						redFlag = true;
						break;
					}
				}

				boolean blueFlag = false;
				while (map[nbx + dx[i]][nby + dy[i]] != '#') {
					nbx += dx[i];
					nby += dy[i];

					if (map[nbx][nby] == 'O') {
						blueFlag = true;
						break;
					}
				}

				if (blueFlag) {
					continue;
				}

				if (redFlag) {
					result = current.count + 1;
					return;
				}

				if (nrx == nbx && nry == nby) {
					int redDist = Math.abs(nrx - current.rx) + Math.abs(nry - current.ry);
					int blueDist = Math.abs(nbx - current.bx) + Math.abs(nby - current.by);

					if (redDist > blueDist) {
						nrx -= dx[i];
						nry -= dy[i];
					} else {
						nbx -= dx[i];
						nby -= dy[i];
					}
				}

				if (!visited[nrx][nry][nbx][nby]) {
					visited[nrx][nry][nbx][nby] = true;
					queue.offer(new State(nrx, nry, nbx, nby, current.count + 1));
				}
			}
		}
	}
}