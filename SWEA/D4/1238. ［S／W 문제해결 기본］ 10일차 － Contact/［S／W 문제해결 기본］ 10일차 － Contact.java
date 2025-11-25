import java.io.*;
import java.util.*;

public class Solution {

	static int t = 10;
	static int n;
	static int m;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			graph = new ArrayList[101];
			for (int i = 0; i < 101; i++) {
				graph[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
			}

			result = bfs(m);

			bw.write("#" + tc + " " + result + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static int bfs(int m) {
		Queue<Integer> queue = new LinkedList<>();
		visited = new boolean[101];

		queue.offer(m);
		visited[m] = true;

		int result = m;
		while (!queue.isEmpty()) {
			int size = queue.size();
			int temp = 0;

			for (int i = 0; i < size; i++) {
				int current = queue.poll();
				temp = Math.max(temp, current);

				for (int next : graph[current]) {
					if (!visited[next]) {
						visited[next] = true;
						queue.offer(next);
					}
				}
			}

			result = temp;
		}

		return result;
	}

}
