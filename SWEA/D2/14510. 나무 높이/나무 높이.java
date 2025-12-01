import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	static int t;
	static int n;
	static int[] trees;
	static int maxHeight;
	static int days;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			trees = new int[n];
			days = 1;
			maxHeight = Integer.MIN_VALUE;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				trees[i] = Integer.parseInt(st.nextToken());

				if (maxHeight < trees[i]) {
					maxHeight = trees[i];
				}
			}

			int cnt1 = 0;
			int cnt2 = 0;
			for (int i = 0; i < n; i++) {
				int diff = maxHeight - trees[i];
				cnt2 += diff / 2;
				cnt1 += diff % 2;
			}
			
			while (cnt2 > cnt1 + 1) {
				cnt2--;
				cnt1 += 2;
			}

			int result = 0;
			if (cnt1 > cnt2) {
				result = cnt1 * 2 - 1;
			} else {
				result = cnt2 * 2;
			}


			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
