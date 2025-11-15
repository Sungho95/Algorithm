import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int m;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			boolean find = false;

			int start = 0;
			int end = n - 1;
			while (start <= end) {
				int midIdx = (start + end) / 2;
				int midVal = nums[midIdx];

				if (midVal > target) {
					end = midIdx - 1;
				} else if (midVal < target) {
					start = midIdx + 1;
				} else {
					find = true;
					break;
				}
			}

			if (find) {
				bw.write("1\n");
			} else {
				bw.write("0\n");
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
