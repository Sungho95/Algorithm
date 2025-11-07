import java.io.*;
import java.util.*;

public class Solution {

	static int t;
	static int n;
	static int m;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			graph = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[x].add(y);
				graph[y].add(x);
			}

			result = 1;
			visited = new boolean[n + 1];

			for (int i = 1; i <= n; i++) {
				visited[i] = true;
				dfs(i, 1);
				visited[i] = false;
			}

			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static void dfs(int current, int length) {
		result = Math.max(result, length);

		for (int next : graph[current]) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, length + 1);
				visited[next] = false;
			}
		}
	}
}