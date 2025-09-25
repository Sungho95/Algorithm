import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] tArr;
	static int[] pArr;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		tArr =  new int[n];
		pArr = new int[n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			tArr[i] = Integer.parseInt(st.nextToken());
			pArr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();

		int[] dp = new int[n + 1];
		for (int i = 0; i < n; i++) {
			if (i + tArr[i] <= n) {
				dp[i + tArr[i]] = Math.max(dp[i + tArr[i]], dp[i] + pArr[i]);
			}

			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}

		bw.write(String.valueOf(dp[n]));
		bw.flush();
		bw.close();
	}
}
