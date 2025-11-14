import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int n;
	static int roomNumber;
	static int roomCount;
	static int[][] rooms;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = new Integer(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			rooms = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			roomNumber = 0;
			roomCount = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int length = bfs(i, j);

					if (length > roomCount || (length == roomCount && roomNumber > rooms[i][j])) {
						roomCount = length;
						roomNumber = rooms[i][j];
					}
				}
			}

			bw.write("#" + tc + " " + roomNumber + " " + roomCount + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static int bfs(int i, int j) {
		int current = rooms[i][j];
		int length = 1;
		int x = i;
		int y = j;

		while (true) {
			boolean isMove = false;

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n && rooms[nx][ny] == current + 1) {
					x = nx;
					y = ny;
					current = rooms[x][y];
					length++;
					isMove = true;
					break;
				}
			}

			if (!isMove) {
				break;
			}
		}

		return length;
	}
}
