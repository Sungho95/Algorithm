import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int n;
	static int m;
	static String[] map;
	static int result;

	static Map<String, Integer> codeMap = new HashMap<>();
	static {
		codeMap.put("0001101", 0);
		codeMap.put("0011001", 1);
		codeMap.put("0010011", 2);
		codeMap.put("0111101", 3);
		codeMap.put("0100011", 4);
		codeMap.put("0110001", 5);
		codeMap.put("0101111", 6);
		codeMap.put("0111011", 7);
		codeMap.put("0110111", 8);
		codeMap.put("0001011", 9);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			map = new String[n];
			for (int i = 0; i < n; i++) {
				map[i] = br.readLine();
			}

			result = solve();

			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static int solve() {
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				if (map[i].charAt(j) == '1') {
					String code = map[i].substring(j - 55, j + 1);
					return decode(code);
				}
			}
		}

		return 0;
	}

	private static int decode(String code) {
		int[] nums = new int[8];

		for (int i = 0; i < 8; i++) {
			String str = code.substring(i * 7, (i + 1) * 7);
			if (codeMap.containsKey(str)) {
				nums[i] = codeMap.get(str);
			} else {
				return 0;
			}
		}

		int oddSum = nums[0] + nums[2] + nums[4] + nums[6];
		int evenSum = nums[1] + nums[3] + nums[5] + nums[7];
		int sum = (oddSum * 3) + evenSum;

		if (sum % 10 == 0) {
			return oddSum + evenSum;
		}

		return 0;
	}

}
