import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int root;
	static int leaf;
	static boolean[] visited;
	static ArrayList<Integer>[] tree;
	static int result;
	static int deleteNode;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		tree = new ArrayList[n];
		visited = new boolean[n];
		result = 0;

		for (int i = 0; i < n; i++) {
			tree[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			leaf = Integer.parseInt(st.nextToken());

			if (leaf != -1) {
				tree[i].add(leaf);
				tree[leaf].add(i);
			} else {
				root = i;
			}
		}

		deleteNode = Integer.parseInt(br.readLine());

		if (deleteNode != root) {
			dfs(root);
			bw.write(String.valueOf(result));
		} else {
			bw.write("0");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static void dfs(int num) {
		visited[num] = true;
		int current = 0;
		for (int i : tree[num]) {
			if (!visited[i] && i != deleteNode) {
				current++;
				dfs(i);
			}
		}

		if (current == 0) {
			result++;
		}
	}
}
