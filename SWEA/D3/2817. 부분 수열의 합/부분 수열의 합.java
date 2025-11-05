import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int n;
	static int k;
	static int[] arr;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			result = 0;
			solve(0, 0);


			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static void solve(int idx, int sum) {
		if (idx == n) {
			if (sum == k) {
				result++;
			}
			return;
		}

		solve(idx + 1, sum);
		solve(idx + 1, sum + arr[idx]);
	}
}