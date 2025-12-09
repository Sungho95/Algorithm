import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			sb = new StringBuilder();
			for (int num : arr) {
				sb.append(num).append(" ");
			}

			bw.write("#" + tc + " " + sb + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
