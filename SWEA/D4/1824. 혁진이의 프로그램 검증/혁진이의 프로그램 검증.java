import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int r;
	static int c;
	static char[][] board;
	static boolean[][][][] visited;
	static String result;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	static int up = 0;
	static int right = 1;
	static int down = 2;
	static int left = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = new Integer(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			board = new char[r][c];
			for (int i = 0; i < r; i++) {
				String line = br.readLine();

				for (int j = 0; j < c; j++) {
					board[i][j] = line.charAt(j);
				}
			}

			result = solve(0, 0);

			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static String solve(int x, int y) {
		visited = new boolean[r][c][4][16];
		visited[x][y][right][0] = true;

		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, right, 0));

		while (!q.isEmpty()) {
			Node curNode = q.poll();
			int curR = curNode.r;
			int curC = curNode.c;
			int curDirection = curNode.direction;
			int curMemory = curNode.memory;

			char ch = board[curR][curC];

			if (ch == '@') {
				return "YES";
			}

			int nextDirection = move(ch, curDirection, curMemory);
			int nextMemory = calculateMemory(ch, curMemory);

			if (ch == '?') {
				for (int i = 0; i < 4; i++) {
					int nr = curR + dx[i];
					int nc = curC + dy[i];

					// 만약 다음 이동이 2차원 격자의 바깥으로 이동하는 방향이면, 반대편에 있는 위치로 이동한다.
					if (nr < 0) {
						nr = r - 1;
					} else if (nr >= r) {
						nr = 0;
					}

					if (nc < 0) {
						nc = c - 1;
					} else if (nc >= c) {
						nc = 0;
					}

					if (!visited[nr][nc][nextDirection][nextMemory]) {
						visited[nr][nc][nextDirection][nextMemory] = true;
						q.offer(new Node(nr, nc, i, nextMemory));
					}
				}
			} else {
				int nr = curR + dx[nextDirection];
				int nc = curC + dy[nextDirection];

				if (nr < 0) {
					nr = r - 1;
				} else if (nr >= r) {
					nr = 0;
				}

				if (nc < 0) {
					nc = c - 1;
				} else if (nc >= c) {
					nc = 0;
				}

				if (!visited[nr][nc][nextDirection][nextMemory]) {
					visited[nr][nc][nextDirection][nextMemory] = true;
					q.offer(new Node(nr, nc, nextDirection, nextMemory));
				}
			}
		}

		return "NO";
	}

	private static int move(char ch, int curDirection, int curMemory) {

		if (ch == '<') {
			curDirection = left;
		} else if (ch == '>') {
			curDirection = right;
		} else if (ch == '^') {
			curDirection = up;
		} else if (ch == 'v') {
			curDirection = down;
		} else if (ch == '_') {
			curDirection = (curMemory == 0 ? right : left);
		} else if (ch == '|') {
			curDirection = (curMemory == 0 ? down : up);
		}

		return curDirection;
	}

	private static int calculateMemory(char ch, int curMemory) {

		if (ch >= '0' && ch <= '9') {
			curMemory = ch - '0';
		} else if (ch == '+') {
			curMemory = (curMemory + 1) % 16;
		} else if (ch == '-') {
			curMemory = (curMemory + 15) % 16;
		}

		return curMemory;
	}

	static class Node {
		int r;
		int c;
		int direction;
		int memory;

		public Node(int r, int c, int direction, int memory) {
			this.r = r;
			this.c = c;
			this.direction = direction;
			this.memory = memory;
		}
	}

}
