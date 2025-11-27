import java.io.*;

public class Solution {

	static int t;
	static int n;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			visited = new boolean[10];
			int visitedCount = 0;
			int k = 0;

			while (visitedCount < 10) {
				k++;
				result = k * n;

				int temp = result;
				while (temp > 0) {
					int digit = temp % 10;

					if (!visited[digit]) {
						visited[digit] = true;
						visitedCount++;
					}
					
					temp /= 10;
				}
			}
			
			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
	
}
