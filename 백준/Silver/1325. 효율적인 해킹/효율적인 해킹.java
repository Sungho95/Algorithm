import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int m;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n + 1];
		answer = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[b].add(a);
		}

		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			bfs(i);
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, answer[i]);
		}

		for (int i = 1; i <= n; i++) {
			if (answer[i] == max) {
				bw.write(i + " ");
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int next : graph[current]) {
				if (!visited[next]) {
					answer[node]++;
					visited[next] = true;
					queue.add(next);
				}
			}
		}
	}
}