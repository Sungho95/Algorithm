import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int n;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			result = 0;
			for (int i = 1; i <= n; i++) {
				if (i % 2 == 0) {
					result -= i;
				} else {
					result += i;
				}
			}

			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
