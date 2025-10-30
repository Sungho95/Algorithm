import java.io.*;
import java.util.*;

public class Solution {

	static int t, n, l;
	static int[] taste;
	static int[] calorie;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			taste = new int[n];
			calorie = new int[n];
			result = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				taste[i] = Integer.parseInt(st.nextToken());
				calorie[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0, 0);

			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static void dfs(int idx, int currentTaste, int currentCalorie) {
		if (currentCalorie > l) {
			return;
		}

		if (idx == n) {
			result = Math.max(result, currentTaste);
			return;
		}

		dfs(idx + 1, currentTaste, currentCalorie);

		if (currentCalorie + calorie[idx] <= l) {
			dfs(idx + 1, currentTaste + taste[idx], currentCalorie + calorie[idx]);
		}
	}
}
