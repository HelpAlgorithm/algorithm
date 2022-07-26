import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while (!str.equals("*")) {
			int N = str.length();
			boolean flag = false;
			outer: for (int j = 0; j <= N-2; j++) {
				Set<String> set = new HashSet<>();
				for (int i = 0; i +j + 1 < N; i++) {
					String temp = ""+ str.charAt(i) + str.charAt(i+j+1);
					if (set.contains(temp)) {
						flag = true;
						System.out.println(str+" is NOT surprising.");
						break outer;
					} else {
						set.add(temp);
					}
				}
			}
			if (!flag) System.out.println(str+" is surprising.");
			str = br.readLine();
		}
	}
}
