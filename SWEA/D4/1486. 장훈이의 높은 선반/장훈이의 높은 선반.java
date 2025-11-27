import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	static int t;
	static int n;
	static int b;
	static int[] h;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			h = new int[n];

			result = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0);

			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static void dfs(int idx, int sum) {
		if (sum >= b) {
			int diff = sum - b;
			result = Math.min(result, diff);
			return;
		}

		if (idx == n) {
			return;
		}

		dfs(idx + 1, sum + h[idx]);
		dfs(idx + 1, sum);
	}

}
