import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int n;
	static int k;
	static double[] scores;
	static String result;

	private static final String[] GRADES = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			scores = new double[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				double avg = (Integer.parseInt(st.nextToken()) * 0.35) + (Integer.parseInt(st.nextToken()) * 0.45) + (
					Integer.parseInt(st.nextToken()) * 0.2);
				scores[i] = avg;
			}

			double target = scores[k - 1];
			Arrays.sort(scores);
			for (int i = 0; i < n; i++) {
				if (scores[i] == target) {
					result = GRADES[i / (n / 10)];
					break;
				}
			}

			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
