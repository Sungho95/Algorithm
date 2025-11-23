import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static PriorityQueue<Integer> plus;
	static PriorityQueue<Integer> minus;
	static int zero;
	static int one;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		plus = new PriorityQueue<>(Collections.reverseOrder());
		minus = new PriorityQueue<>();
		zero = 0;

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 1) {
				plus.add(num);
			} else if (num == 1) {
				one++;
			} else if (num == 0) {
				zero++;
			} else {
				minus.add(num);
			}
		}

		result = 0;
		while (plus.size() >= 2) {
			int first = plus.poll();
			int second = plus.poll();
			result += first * second;
		}

		if (!plus.isEmpty()) {
			result += plus.poll();
		}

		while (minus.size() >= 2) {
			int first = minus.poll();
			int second = minus.poll();
			result += first * second;
		}

		while (!minus.isEmpty()) {
			int num = minus.poll();
			if (zero == 0) {
				result += num;
			} else {
				zero--;
			}
		}

		result += one;

		bw.write(String.valueOf(result));
		br.close();
		bw.flush();
		bw.close();
	}
}