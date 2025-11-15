import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		dp = new long[n + 1][2];

		dp[1][0] = 0;
		dp[1][1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][1] + dp[i - 1][0];
			dp[i][1] = dp[i - 1][0];
		}
		
		bw.write(String.valueOf(dp[n][0] + dp[n][1]));
		br.close();
		bw.flush();
		bw.close();
	}
}
