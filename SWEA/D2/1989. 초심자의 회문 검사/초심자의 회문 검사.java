import java.io.*;

public class Solution {

	static int t;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			result = isPalindrome(br.readLine());
			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static int isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return 0;
			}

			start++;
			end--;
		}
		return 1;
	}

}