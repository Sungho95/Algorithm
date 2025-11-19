import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int n;
	static int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = new Integer(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			result = new int[8];

			for (int i = 0; i < money.length; i++) {
				result[i] = n / money[i];
				n = n % money[i];
			}

			bw.write("#" + tc + "\n");
			for (int j : result) {
				bw.write(j + " ");
			}
			bw.write("\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
