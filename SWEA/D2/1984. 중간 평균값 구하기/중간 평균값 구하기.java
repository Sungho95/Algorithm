import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int min;
	static int max;
	static int sum;
	static int[] nums;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			nums = new int[10];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				nums[i] = Integer.parseInt(st.nextToken());

				if (nums[i] > max) {
					max = nums[i];
				}

				if (nums[i] < min) {
					min = nums[i];
				}
			}

			sum = 0;
			for (int i = 0; i < 10; i++) {
				if (nums[i] != min && nums[i] != max) {
					sum += nums[i];
				}
			}

			result = (int)Math.round((double)sum / 8);

			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
