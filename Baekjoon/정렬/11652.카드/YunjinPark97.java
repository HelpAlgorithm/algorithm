package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class Baekjoon11652_카드 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Long, Integer> cardMap = new HashMap<Long, Integer>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			Long card = Long.parseLong(br.readLine());
			if (cardMap.containsKey(card)) {
				cardMap.put(card, cardMap.get(card) + 1);
			}else {
			cardMap.put(card, 1);
			}
		}
		long mostCommonCard = Long.MAX_VALUE; // 카드 값
		int mostCommonNum = 0; // 횟수
		for (Entry<Long, Integer> entry: cardMap.entrySet()) {
			if (mostCommonNum <= entry.getValue()) {
				if (mostCommonNum < entry.getValue() || mostCommonCard > entry.getKey()) {
					mostCommonNum = entry.getValue();
					mostCommonCard = entry.getKey();
				}
			}
		}
		System.out.println(mostCommonCard);
	}

}
