import java.io.*;

public class Solution {

	static int t;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			bw.write("#" + tc + "\n");
			printPascalTriangle(n, bw);
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static void printPascalTriangle(int n, BufferedWriter bw) throws IOException {
		int[][] triangle = new int[n][];

		for (int i = 0; i < n; i++) {
			triangle[i] = new int[i + 1];
			triangle[i][0] = 1;
			triangle[i][i] = 1;

			for (int j = 1; j < i; j++) {
				triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
			}

			for (int j = 0; j <= i; j++) {
				bw.write(triangle[i][j] + " ");
			}
			bw.write("\n");
		}
	}

}