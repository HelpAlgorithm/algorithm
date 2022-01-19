import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Chiyongs {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] a = s.split(" ");

		int n = Integer.parseInt(a[0]);
		int b = Integer.parseInt(a[1]);

		String result = "";

		while (true) {
			int m = n % b;
			if (m > 9) {
				m = m - 10 + 65;
				result = String.valueOf((char) m) + result;
			} else {
				result = String.valueOf(m) + result;
			}

			n = n / b;
			if (n == 0)
				break;
		}

		System.out.println(result);

	}

}
