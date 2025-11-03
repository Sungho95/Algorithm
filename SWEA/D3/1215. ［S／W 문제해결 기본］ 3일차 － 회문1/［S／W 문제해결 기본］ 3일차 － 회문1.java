import java.util.*;
import java.io.*;

public class Solution {

	static int n;
	static char[][] board;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int tc = 1; tc <= 10; tc++) {
			n = Integer.parseInt(br.readLine());
			board = new char[8][8];
			result = 0;

			for (int i = 0; i < 8; i++) {
				String line = br.readLine();

				for (int j = 0; j < 8; j++) {
					board[i][j] = line.charAt(j);
				}
			}

			StringBuilder sb;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - n + 1; j++) {
					sb = new StringBuilder();
					for (int k = j; k < j + n; k++) {
						sb.append(board[i][k]);
					}

					if (isPalindrome(sb)) {
						result++;
					}
				}
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - n + 1; j++) {
					sb = new StringBuilder();
					for (int k = j; k < j + n; k++) {
						sb.append(board[k][i]);
					}

					if (isPalindrome(sb)) {
						result++;
					}
				}
			}

			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static boolean isPalindrome(StringBuilder sb) {
		String str = sb.toString();
		String reverse = sb.reverse().toString();
		return str.equals(reverse);
	}

}