import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<Edge>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		distance = new int[n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());

			while (st.hasMoreTokens()) {
				int e = Integer.parseInt(st.nextToken());
				if (e == -1) {
					break;
				}
				int v = Integer.parseInt(st.nextToken());
				list[s].add(new Edge(e, v));
			}
		}

		bfs(1);

		int idx = 1;
		for (int i = 2; i <= n; i++) {
			if (distance[idx] < distance[i]) {
				idx = i;
			}
		}

		distance = new int[n + 1];
		visited = new boolean[n + 1];
		bfs(idx);
		Arrays.sort(distance);

		bw.write(distance[n] + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(idx);
		visited[idx] = true;

		while (!q.isEmpty()) {
			int current = q.poll();

			for (Edge edge : list[current]) {
				int e = edge.e;
				int v = edge.v;

				if (!visited[e]) {
					visited[e] = true;
					q.offer(e);
					distance[e] = distance[current] + v;
				}
			}
		}
	}

	static class Edge {
		int e;
		int v;

		public Edge(int e, int v) {
			this.e = e;
			this.v = v;
		}

		@Override
		public String toString() {
			return "Edge{" +
				"e=" + e +
				", value=" + v +
				'}';
		}
	}
}
