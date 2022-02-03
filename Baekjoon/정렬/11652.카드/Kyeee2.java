package algorithm_me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Kyeee2 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Long, Integer> count = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			long n = Long.parseLong(br.readLine());
			
			if(count.containsKey(n)) {
				count.replace(n, count.get(n), count.get(n) + 1);
			} else {
				count.put(n, 1);
			}
		}

		int max = -1;
		long n = 0;
		for(Entry<Long, Integer> num: count.entrySet()) {
			if(num.getValue() > max) {
				max = num.getValue();
				n = num.getKey();
			} else if(num.getValue() == max) {
				 if(num.getKey() < n) {
					 n = num.getKey();
				 }
			}
		}
		
		System.out.println(n);
		
		/* 이렇게 하니까 틀림... */
		/*
		List<Entry<Long, Integer>> lists = new ArrayList<>(count.entrySet());
		Collections.sort(lists, (n1, n2) -> {
			if(n1.getValue() == n2.getValue()) {
				return Long.compare(n1.getKey(), n2.getKey());
			} else {
				return Integer.compare(n1.getValue(), n2.getValue()) * -1;
			}
		});
		
		System.out.println(lists.get(0).getKey());
		*/
		
	}
	
}