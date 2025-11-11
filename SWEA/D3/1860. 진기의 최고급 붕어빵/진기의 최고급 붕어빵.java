import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int n;
	static int m;
	static int k;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = new Integer(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			boolean flag = true;
			for (int i = 0; i < n; i++) {
				int time = arr[i];
				int count = i + 1;
				if ((time / m) * k < count) {
					flag = false;
					break;
				}
			}

			bw.write("#" + tc + " " + (flag ? "Possible" : "Impossible") + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
