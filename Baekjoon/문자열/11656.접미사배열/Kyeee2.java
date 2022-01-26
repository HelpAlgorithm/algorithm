package algorithm_me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kyeee2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String [] words = new String[str.length()];
		
		// 접미사 배열로 만들기
		for(int i = 0; i < str.length(); i++) {
			words[i] = str.substring(i);
		}
		
		// 사전순으로 버블정렬
		/*
		for(int i = 0; i < words.length - 1; i++) {
			for(int j = 0; j < words.length - 1; j++) {
				if(words[j].compareTo(words[j + 1]) > 0) {
					String temp = words[j];
					words[j] = words[j + 1];
					words[j + 1] = temp;
				}
			}
		}
		*/
		
		Arrays.sort(words, (w1, w2) -> w1.compareTo(w2));		
		
		for(String word: words) {
			System.out.println(word);
		}
	}

}
