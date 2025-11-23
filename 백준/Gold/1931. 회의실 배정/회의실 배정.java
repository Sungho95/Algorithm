import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[][] meetings;
	static int end;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		meetings = new int[n][2];

		StringTokenizer st;
		for (int i = 0; i< n; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(meetings, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		});

		result = 0;
		end = -1;
		for (int i = 0; i < n; i++) {
			if (meetings[i][0] >= end) {
				end = meetings[i][1];
				result++;
			}
		}

		bw.write(String.valueOf(Main.result));
		br.close();
		bw.flush();
		bw.close();
	}
}