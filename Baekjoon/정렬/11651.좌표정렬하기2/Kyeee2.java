package algorithm_me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Pair> points = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			
			points.add(new Pair(x, y));
		}
		
		Collections.sort(points, new Comparator<Pair> () {

			@Override
			public int compare(Pair p1, Pair p2) {
				if(p1.y == p2.y) {
					return Integer.compare(p1.x, p2.x);
				} else {
					return Integer.compare(p1.y, p2.y);
				}
			}
			
		});
		
		for(Pair point: points) {
			System.out.println(point.x + " " + point.y);
		}
		
	}
	
}

class Pair {
	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
