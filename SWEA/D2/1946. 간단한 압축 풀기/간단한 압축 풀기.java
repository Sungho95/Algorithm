import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int n;
	static String c;
	static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());

			sb = new StringBuilder();
			int count = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				c = st.nextToken();
				k = Integer.parseInt(st.nextToken());

				for (int j = 0; j < k; j++) {
					sb.append(c);
					count++;

					if (count % 10 == 0) {
						sb.append("\n");
					}
				}
			}

			bw.write("#" + tc + "\n" + sb + "\n");

		}

		br.close();
		bw.flush();
		bw.close();
	}

}
