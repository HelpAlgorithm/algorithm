import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M;
	static int [] level = new int [100001]; // 인덱스: 문제 번호, level[n]: n번 문제의 난이도
	static TreeMap<Integer, TreeSet<Integer>> Quest = new TreeMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(tokens.nextToken());
			int l = Integer.parseInt(tokens.nextToken());
			
			if(!Quest.containsKey(l)) {
				Quest.put(l, new TreeSet<>());
			} 
			Quest.get(l).add(p);
			level[p] = l;
		}
		
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			String op = tokens.nextToken();
			switch(op) {
			case "add": // 문제 추가
				int p = Integer.parseInt(tokens.nextToken());
				int l = Integer.parseInt(tokens.nextToken());
				
				if(!Quest.containsKey(l)) {
					Quest.put(l, new TreeSet<>());
				} 
				Quest.get(l).add(p);
				level[p] = l;
				break;
			case "solved": // 문제 삭제
				p = Integer.parseInt(tokens.nextToken());
				Quest.get(level[p]).remove(p);
				// 해당 레벨에 더이상 문제가 없다면 TreeSet 지우기
				if(Quest.get(level[p]).size() == 0) {
					Quest.remove(level[p]);
				}
				// 해당 문제의 레벨 지우기
				level[p] = 0;
				break;
			case "recommend": // 문제 추천
				int x = Integer.parseInt(tokens.nextToken());
				if(x == 1) { // 가장 어려운 문제
					l = Quest.lastKey(); // 가장 어려운 레벨
					output.append(Quest.get(l).last() + "\n"); // 가장 큰 문제번호
				} else { // 가장 쉬운 문제
					l = Quest.firstKey(); // 가장 쉬운 레벨
					output.append(Quest.get(l).first() + "\n"); // 가장 큰 문제번호
				}
				break;
			}
		}
		System.out.println(output);
	}

}
