import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int startMonth;
	static int startDay;
	static int endMonth;
	static int endDay;
	static int result;

	static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			startMonth = Integer.parseInt(st.nextToken());
			startDay = Integer.parseInt(st.nextToken());
			endMonth = Integer.parseInt(st.nextToken());
			endDay = Integer.parseInt(st.nextToken());

			result = solve(startMonth, startDay, endMonth, endDay);

			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static int solve(
		int startMonth,
		int startDay,
		int endMonth,
		int endDay
	) {
		int addDay = 0;
		for (int i = 0; i < endMonth - startMonth; i++) {
			addDay += days[startMonth + i - 1];
		}

		return addDay + (endDay - startDay + 1);
	}

}
