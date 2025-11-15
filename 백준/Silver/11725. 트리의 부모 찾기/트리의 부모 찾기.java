import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static boolean[] visited;
	static ArrayList<Integer>[] tree;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		tree = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		result = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			tree[n1].add(n2);
			tree[n2].add(n1);
		}

		dfs(1);

		for (int i = 2; i < n + 1; i++) {
			bw.write(result[i] + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static void dfs(int idx) {
		visited[idx] = true;

		for (int n : tree[idx]) {
			if (!visited[n]) {
				result[n] = idx;
				dfs(n);
			}
		}
	}
}
