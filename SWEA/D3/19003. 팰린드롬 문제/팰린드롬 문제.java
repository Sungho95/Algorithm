import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] input = sc.nextLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			int result = 0;

			Set<String> set = new HashSet<>();
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				String word = sc.nextLine();
				if (isPalindrome(word)) {
					flag = true;
				} else {
					String reverse = reverse(word);
					if (set.contains(reverse)) {
						result += M * 2;
					} else {
						set.add(word);
					}
				}
			}

			if (flag) {
				result += M;
			}

			System.out.println("#" + test_case + " " + result);
		}
	}

	// 문자열 뒤집기
	private static String reverse(String word) {
		char[] arr = word.toCharArray();
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}

		return String.valueOf(arr);
	}

	// 팰린드롬인지 확인
	private static boolean isPalindrome(String word) {
		for (int i = 0; i < word.length() / 2; i++) {
			if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
				return false;
			}
		}

		return true;
	}
}