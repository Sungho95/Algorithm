import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int m;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[n];

		int start = 0;
		int end = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());

			if (start < nums[i]) {
				start = nums[i];
			}
			end += nums[i];
		}

		while (start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			int count = 0;

			for (int i = 0; i < n; i++) {
				if (sum + nums[i] > mid) {
					count++;
					sum = 0;
				}
				sum += nums[i];
			}

			if (sum != 0) {
				count++;
			}

			if (count > m) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}
		
		bw.write(String.valueOf(start));
		br.close();
		bw.flush();
		bw.close();
	}
}
