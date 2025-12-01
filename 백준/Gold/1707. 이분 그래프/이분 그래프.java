import java.io.*;
import java.util.*;

public class Main {

	static int k;
	static int v;
	static int e;
	static List<List<Integer>> graph;
	static int[] check;
	static boolean[] visited;
	static boolean isEven;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		k = Integer.parseInt(br.readLine());
		for (int t = 0; t < k; t++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			check = new int[v + 1];
			visited = new boolean[v + 1];
			isEven = true;

			for (int i = 0; i < v + 1; i++) {
				graph.add(new ArrayList<>());
			}

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				graph.get(start).add(end);
				graph.get(end).add(start);
			}

			for (int i = 1; i <= v; i++) {
				if (isEven) {
					dfs(i);
				} else {
					break;
				}
			}

			if (isEven) {
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static void dfs(int start) {
		visited[start] = true;
		for (int next : graph.get(start)) {
			if (!visited[next]) {
				check[next] = (check[start] + 1) % 2;
				dfs(next);
			} else if (check[next] == check[start]) {
				isEven = false;
			}
		}
	}
	
}