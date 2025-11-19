import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int n;

	static final int SIZE = 8;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		t = 10;

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Queue<Integer> q = new LinkedList<>();

			while (st.hasMoreTokens()) {
				q.offer(Integer.parseInt(st.nextToken()));
			}

			int decrease = 1;
			while (!q.isEmpty()) {
				int num = q.poll();
				num -= decrease;

				if (num <= 0) {
					num = 0;
					q.offer(num);
					break;
				}
				q.offer(num);

				decrease++;
				if (decrease > 5) {
					decrease = 1;
				}
			}

			sb = new StringBuilder();
			while (!q.isEmpty()) {
				sb.append(q.poll()).append(" ");
			}
			bw.write("#" + n + " " + sb + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
