import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int h;
	static int w;
	static char[][] arr;
	static int count;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			arr = new char[h][w];
			count = 0;

			for (int i = 0; i < h; i++) {
				String input = br.readLine();
				for (int j = 0; j < w; j++) {
					arr[i][j] = input.charAt(j);
				}
			}

			for (int i = 0; i < h; i++) {
				boolean flag = true;
				for (int j = 0; j < w; j++) {
					if (arr[i][j] != '#') {
						flag = false;
						break;
					}
				}
				
				if (flag) {
					count++;
				}
			}

			for (int i = 0; i < w; i++) {
				boolean flag = true;
				for (int j = 0; j < h; j++) {
					if (arr[j][i] != '#') {
						flag = false;
						break;
					}
				}
				
				if (flag) {
					count++;
				}
			}
			
			if (count == w + h) {
				count = Math.min(w, h);
			}

			bw.write(count + "\n");
		}
		br.close();

		bw.flush();
		bw.close();
	}
}
