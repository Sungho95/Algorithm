import java.io.*;
import java.util.*;

public class Main {

	static int v;
	static int e;
	static int k;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<Edge>[] list;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());

		distance = new int[v + 1];
		visited = new boolean[v + 1];
		list = new ArrayList[v + 1];
		for (int i = 0; i < v + 1; i++) {
			list[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Edge(v, w));
		}

		pq.offer(new Edge(k, 0));
		distance[k] = 0;

		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			int currentVertex = current.vertex;
			int currentWeight = current.weight;

			if (visited[currentVertex]) {
				continue;
			}

			visited[currentVertex] = true;

			for (Edge next : list[currentVertex]) {
				int nextVertex = next.vertex;
				int nextWeight = next.weight;

				if (distance[nextVertex] > distance[currentVertex] + nextWeight) {
					distance[nextVertex] = distance[currentVertex] + nextWeight;
					pq.offer(new Edge(nextVertex, distance[nextVertex]));
				}
			}
		}

		for (int i = 1; i < v + 1; i++) {
			if (visited[i]) {
				bw.write(distance[i] + "\n");
			} else {
				bw.write("INF\n");
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static class Edge implements Comparable<Edge> {
		int vertex;
		int weight;

		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.weight, e.weight);
		}
	}
}
