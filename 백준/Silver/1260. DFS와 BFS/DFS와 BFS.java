import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int m;
	static int v;
	static ArrayList<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 0; i <= n; i++) {
			Collections.sort(list[i]);
		}

		visited = new boolean[n + 1];
		dfs(v, bw);

		bw.write("\n");

		visited = new boolean[n + 1];
		bfs(v, bw);
		br.close();
		bw.flush();
		bw.close();
	}

	private static void dfs(int num, BufferedWriter bw) throws IOException {
		bw.write(num + " ");
		visited[num] = true;
		for (int i = 0; i < list[num].size(); i++) {
			int next = list[num].get(i);

			if (!visited[next]) {
				dfs(next, bw);
			}
		}
	}

	private static void bfs(int num, BufferedWriter bw) throws IOException {
		Queue<Integer> q = new LinkedList<>();
		q.offer(num);
		visited[num] = true;

		while (!q.isEmpty()) {
			int current = q.poll();
			bw.write(current + " ");

			for (int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i);

				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
	}
}
