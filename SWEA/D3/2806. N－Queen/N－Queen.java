import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	static int n;
	static int[] board;
	static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			board = new int[n];
			count = 0;

			nQueen(n, 0);

			bw.write("#" + tc + " " + count + "\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}

	private static void nQueen(final int n, final int start) {
		if (start == n) {
			count++;
			return;
		}

		for (int i = 0; i < n; i++) {
			boolean flag = true;
			for (int j = 0; j < start; j++) {
				if (i == board[j] || i == board[j] + start - j || i == board[j] - start + j) {
					flag = false;
					break;
				}
			}

			if (flag) {
				board[start] = i;
				nQueen(n, start + 1);
			}
		}
	}
}
