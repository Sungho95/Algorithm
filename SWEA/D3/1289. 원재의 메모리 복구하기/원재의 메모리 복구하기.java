import java.io.*;

public class Solution {

	static int t;
	static String s;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			s = br.readLine();
			result = 0;
			char current = '0';

			for (int i = 0; i < s.length(); i++) {
				if (current != s.charAt(i)) {
					result++;
					current = s.charAt(i);
				}
			}

			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}