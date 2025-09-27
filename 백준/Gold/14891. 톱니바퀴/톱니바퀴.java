import java.io.*;
import java.util.*;

public class Main {

	static int[][] cogwheels = new int[4][8];
	static int k;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 4; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < input.length; j++) {
				cogwheels[i][j] = Integer.parseInt(input[j]);
			}
		}

		k = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());

			solve(num, d);
		}
		br.close();

		result = 0;
		for (int i = 0; i < 4; i++) {
			if (cogwheels[i][0] == 1) {
				result += (int)Math.pow(2, i);
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	private static void solve(int num, int d) {
		left(num - 1, -d);
		right(num + 1, -d);
		move(num, d);
	}

	private static void left(int num, int d) {
		if (num < 0 || (cogwheels[num][2] == cogwheels[num + 1][6])) {
			return;
		}

		left(num - 1, -d);
		move(num, d);
	}

	private static void right(int num, int d) {
		if (num > 3 || (cogwheels[num][6] == cogwheels[num - 1][2])) {
			return;
		}

		right(num + 1, -d);
		move(num, d);
	}

	private static void move(int num, int d) {
		if (d == 1) { // 시계방향
			int temp = cogwheels[num][7];
			for (int i = cogwheels[num].length - 1; i > 0; i--) {
				cogwheels[num][i] = cogwheels[num][i - 1];
			}
			cogwheels[num][0] = temp;
		} else { // 반시계방향
			int temp = cogwheels[num][0];
			for (int i = 0; i < cogwheels[num].length - 1; i++) {
				cogwheels[num][i] = cogwheels[num][i + 1];
			}
			cogwheels[num][7] = temp;
		}
	}
}
