import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int[] arrA;
	static int[] arrB;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int aLength = Integer.parseInt(st.nextToken());
			int bLength = Integer.parseInt(st.nextToken());

			arrA = new int[aLength];
			arrB = new int[bLength];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < aLength; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < bLength; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arrA);
			Arrays.sort(arrB);

			if (Arrays.equals(arrA, arrB)) {
				bw.write("=\n");
				continue;
			} else if (arrA.length < arrB.length) {
				if (isSubSet(arrB, arrA)) {
					bw.write("<\n");
					continue;
				}
			} else {
				if (isSubSet(arrA, arrB)) {
					bw.write(">\n");
					continue;
				}
			}

			bw.write("?\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static boolean isSubSet(int[] superSet, int[] subSet) {
		Set<Integer> set = new HashSet<>();
		for (int element : superSet) {
			set.add(element);
		}

		for (int element : subSet) {
			if (!set.contains(element)) {
				return false;
			}
		}

		return true;
	}
}
