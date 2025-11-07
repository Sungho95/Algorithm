import java.io.*;
import java.util.*;

public class Solution {

	static final int T = 10;
	static final int SIZE = 100;
	static int t;
	static int result;
	static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;

		for (int tc = 1; tc <= T; tc++) {
			t = Integer.parseInt(br.readLine());
			board = new char[SIZE][SIZE];
			result = 0;

			for (int i = 0; i < SIZE; i++) {
				String input = br.readLine();
				for (int j = 0; j < SIZE; j++) {
					board[i][j] = input.charAt(j);
				}
			}

			// 가로 방향 회문 찾기
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					for (int k = j; k < SIZE; k++) {
						if (isPalindrome(board[i], j, k)) {
							result = Math.max(result, k - j + 1);
						}
					}
				}
			}

			// 세로 방향 회문 찾기
			for (int j = 0; j < SIZE; j++) {
				for (int i = 0; i < SIZE; i++) {
					for (int k = i; k < SIZE; k++) {
						if (isPalindromeVertical(j, i, k)) {
							result = Math.max(result, k - i + 1);
						}
					}
				}
			}

			bw.write("#" + t + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	// 가로 방향 회문 검사
	static boolean isPalindrome(char[] row, int start, int end) {
		while (start < end) {
			if (row[start] != row[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	// 세로 방향 회문 검사
	static boolean isPalindromeVertical(int col, int start, int end) {
		while (start < end) {
			if (board[start][col] != board[end][col]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}