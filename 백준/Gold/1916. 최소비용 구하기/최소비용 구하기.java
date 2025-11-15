import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int m;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<Node>[] list;
	static int start;
	static int end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		distance = new int[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		br.close();

		bw.write(String.valueOf(dijkstra(start, end)));
		bw.flush();
		bw.close();
	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Node currentNode = pq.poll();
			int current = currentNode.target;
			if (!visited[current]) {
				visited[current] = true;

				for (Node node : list[current]) {
					if (!visited[node.target] && distance[node.target] > distance[current] + node.value) {
						distance[node.target] = distance[current] + node.value;
						pq.offer(new Node(node.target, distance[node.target]));
					}
				}
			}
		}

		return distance[end];
	}

	static class Node implements Comparable<Node> {
		int target;
		int value;

		public Node(int target, int value) {
			this.target = target;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	}
}
