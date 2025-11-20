import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int m;
	static List<List<Edge>> edges;
	static long[] dist;

	static class Edge {
		int end;
		int time;

		public Edge(int end, int time) {
			this.end = end;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dist = new long[n + 1];
		edges = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			dist[i] = Long.MAX_VALUE;
			edges.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges.get(a).add(new Edge(b, c));
		}

		StringBuilder sb = new StringBuilder();
		if (bellmanFord(1)) {
			sb.append("-1\n");
		} else {
			for (int i = 2; i <= n; i++) {
				if (dist[i] == Long.MAX_VALUE) {
					sb.append("-1\n");
				} else {
					sb.append(dist[i]).append("\n");
				}
			}
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

	private static boolean bellmanFord(int start) {
		dist[start] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (Edge edge : edges.get(j)) {
					if (dist[j] == Long.MAX_VALUE) {
						continue;
					}

					if (dist[j] + edge.time < dist[edge.end]) {
						dist[edge.end] = dist[j] + edge.time;

						if (i == n) {
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
}