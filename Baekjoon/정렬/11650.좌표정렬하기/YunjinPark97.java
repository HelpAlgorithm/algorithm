package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon11650_좌표정렬하기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Pair> coords = new ArrayList<Pair>();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			coords.add(new Pair(a, b));
		}
		Collections.sort(coords);
		for (int i = 0; i < n; i++) {
			System.out.println(coords.get(i));
		}
	}	
}

class Pair implements Comparable<Pair>{
	private int x;
	private int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Pair o) {
		if (o.x == x) {
			return Integer.compare(y, o.y);
		}
		return Integer.compare(x, o.x);
	}

	@Override
	public String toString() {
		return x+" "+y;
	}
}