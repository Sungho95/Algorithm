import java.io.*;
import java.util.*;

public class Solution {

	static int n;
	static int[] points;
	static int result;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			points = new int[n];
			result = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				points[i] = Integer.parseInt(st.nextToken());
			}

			int total = 0;
			for (int i = 0; i < n - 1; i++) {
				total += Math.abs(points[i + 1] - points[i]);
			}
            
			for (int i = 1; i < n - 1; i++) {
				int sub = Math.abs(points[i] - points[i - 1]) + Math.abs(points[i + 1] - points[i]);
				int add = Math.abs(points[i + 1] - points[i - 1]);
				result = Math.min(result, total - sub + add);
			}

			bw.write(result + "\n");
		}
		br.close();

		bw.flush();
		br.close();
		bw.close();
	}
}
