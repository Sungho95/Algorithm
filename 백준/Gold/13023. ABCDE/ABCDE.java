import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int m;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n];
		visited = new boolean[n];
		flag = false;

		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		for (int i =0; i < n; i++) {
			dfs(i, 1);

			if (flag) {
				break;
			}
		}

		if (flag) {
			bw.write("1");
		} else {
			bw.write("0");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	public static void dfs(int current, int depth) {
		if (depth == 5 || flag) {
			flag = true;
			return;
		}

		visited[current] = true;
		for (int i = 0; i < list[current].size(); i++) {
			int next = list[current].get(i);

			if (!visited[next]) {
				dfs(next, depth + 1);
			}
		}
		visited[current] = false;
	}
}
