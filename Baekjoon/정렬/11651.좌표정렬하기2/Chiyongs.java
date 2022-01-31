package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Chiyongs {
	
	static class Coord {
		int x;
		int y;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Coord[] coords = new Coord[n];

		for (int i = 0; i < n; i++) {
			Coord c = new Coord();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			c.x = Integer.parseInt(st.nextToken());
			c.y = Integer.parseInt(st.nextToken());
			coords[i] = c;
		}

		Arrays.sort(coords,new Comparator<Coord>() {
			@Override
			public int compare(Coord o1, Coord o2) {
				if(o1.y == o2.y) {
					return Integer.compare(o1.x, o2.x);
				} else {
					return Integer.compare(o1.y, o2.y);
				}
			}});
		
		StringBuilder sb = new StringBuilder();

		for (Coord x:coords ) {
			sb.append(x.x);
			sb.append(' ');
			sb.append(x.y);
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
