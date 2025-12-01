import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int n;
	static int[] nums = {2, 3, 5, 7, 11};
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			result = new int[5];

			for (int i = 0; i < nums.length; i++) {
				while (n % nums[i] == 0) {
					result[i]++;
					n /= nums[i];
				}
			}

			bw.write("#" + tc + " " + result[0] + " " + result[1] + " " + result[2] + " " + result[3] + " " + result[4] + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
