package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1759_암호만들기 {
	static StringBuilder sb = new StringBuilder();
	static int L;
	static String[] alphabets;
	static String consonants = "bcdfghjklmnpqrstvwxyz";
	static String vowels = "aeiou";
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		alphabets = new String[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) alphabets[i] = st.nextToken();
		
		Arrays.sort(alphabets);
		comb(0, 0, "");
		System.out.println(sb.toString());
	}
	
	static void comb(int cnt, int idx, String str) {
		if (cnt == L) {
			if (hasVowel(str) && haveConsonants(str)) sb.append(str+"\n");
			return;
		}
		
		for (int i = idx; i < alphabets.length; i++) {
			comb(cnt+1, i+1, str+(alphabets[i]));
		}
	}
	
	static boolean hasVowel(String str) {
		for (int i = 0; i < vowels.length(); i++) {
			if (str.contains(vowels.subSequence(i, i+1))) return true;
		}
		return false;
	}
	
	static boolean haveConsonants(String str) {
		int count = 0;
		for (int i = 0; i < consonants.length(); i++) {
			if (str.contains(consonants.charAt(i)+"")) count++;
			if (count >= 2) return true;
		}
		return false;
	}

}
