import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int n;
	static int m;
	static int[] a;
	static int[] b;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			a = new int[n];
			b = new int[m];
			result = Integer.MIN_VALUE;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}

			if (m > n) {
				for (int i = 0; i <= m - n; i++) {
					int sum = 0;
					for (int j = 0; j < n; j++) {
						sum += a[j] * b[i + j];
					}
					result = Math.max(result, sum);
				}
			} else {
				for (int i = 0; i <= n - m; i++) {
					int sum = 0;
					for (int j = 0; j < m; j++) {
						sum += b[j] * a[i + j];
					}
					result = Math.max(result, sum);
				}
			}

			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
