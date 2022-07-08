import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int g = gcd(a, b);
		System.out.println(a+b-g);
	}
	
	static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a%b);
	}

}
