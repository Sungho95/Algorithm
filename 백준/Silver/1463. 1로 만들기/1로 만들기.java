import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];

		dp[1] = 0;

		for (int i = 2; i < n + 1; i++) {
			dp[i] = dp[i - 1] + 1;

			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}

			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}

		bw.write(String.valueOf(dp[n]));
		br.close();
		bw.flush();
		bw.close();
	}
}
