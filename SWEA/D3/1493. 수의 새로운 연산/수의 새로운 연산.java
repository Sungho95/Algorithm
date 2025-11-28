import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	static int t;
	static int p;
	static int q;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());

			// 1. p와 q의 좌표를 찾습니다. (&(p), &(q))
			Point pPoint = getCoordinate(p);
			Point qPoint = getCoordinate(q);

			// 2. 두 좌표를 더합니다. (&(p) + &(q))
			int newX = pPoint.x + qPoint.x;
			int newY = pPoint.y + qPoint.y;

			// 3. 새로운 좌표에 해당하는 숫자를 찾습니다. #(&(p)+&(q))
			result = getValue(newX, newY);

			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Point getCoordinate(int val) {
		int diagonal = 1;
		while (val > diagonal) {
			val -= diagonal;
			diagonal++;
		}
		int x = val;
		int y = diagonal - val + 1;
		return new Point(x, y);
	}

	static int getValue(int x, int y) {
		int diagonal = x + y - 1;
		int prevSum = diagonal * (diagonal - 1) / 2;
		return prevSum + x;
	}

}
