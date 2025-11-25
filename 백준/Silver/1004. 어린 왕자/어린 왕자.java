import java.io.*;
import java.util.*;

public class Main {

	static int t;
	static int x1;
	static int y1;
	static int x2;
	static int y2;
	static int n;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			n = Integer.parseInt(br.readLine());
			count = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());

				boolean startInside = isInside(x1, y1, cx, cy, r);
				boolean endInside = isInside(x2, y2, cx, cy, r);

				if (startInside != endInside) {
					count++;
				}
			}

			bw.write(count + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static boolean isInside(int x, int y, int cx, int cy, int r) {
		return (Math.pow(x - cx, 2) + Math.pow(y - cy, 2)) < Math.pow(r, 2);
	}
}