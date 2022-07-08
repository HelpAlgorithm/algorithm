package test;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double max = 0;
		double sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			double cur = Double.parseDouble(st.nextToken());
			if (max < cur) max = cur;
			sum += cur;
		}
		System.out.println((sum-max)/2+max);
	}

}
