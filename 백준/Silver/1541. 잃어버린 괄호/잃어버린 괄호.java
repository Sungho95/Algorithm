import java.io.*;
import java.util.*;

public class Main {

	static String line;
	static String[] split;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		line = br.readLine();
		split = line.split("-");

		result = 0;
		for (int i = 0; i < split.length; i++) {
			int sum = splitSum(split[i]);
			if (i == 0) {
				result += sum;
			} else {
				result -= sum;
			}
		}

		bw.write(String.valueOf(Main.result));
		br.close();
		bw.flush();
		bw.close();
	}

	private static int splitSum(String s) {
		String[] split = s.split("[+]");

		int sum = 0;
		for (String num : split) {
			sum += Integer.parseInt(num);
		}

		return sum;
	}
}