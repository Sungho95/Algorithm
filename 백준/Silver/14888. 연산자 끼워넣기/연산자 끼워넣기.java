import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[] nums;
	static int[] operators = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		nums = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
		br.close();

		dfs(nums[0], 1);

		bw.write(max + "\n" + min);
		bw.flush();
		bw.close();
	}

	private static void dfs(final int num, final int idx) {
		if (idx == n) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operators[i] > 0) {
				operators[i]--;

				if (i == 0) {
					dfs(num + nums[idx], idx + 1);
				} else if (i == 1) {
					dfs(num - nums[idx], idx + 1);
				} else if (i == 2) {
					dfs(num * nums[idx], idx + 1);
				} else if (i == 3) {
					dfs(num / nums[idx], idx + 1);
				}

				operators[i]++;
			}
		}
	}
}
