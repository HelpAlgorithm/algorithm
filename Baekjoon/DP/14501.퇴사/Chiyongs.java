package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chiyongs {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] task = new int[T][2];
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			task[i][0] = Integer.parseInt(st.nextToken());
			task[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] d = new int[T];
		
		for(int i=0;i<T;i++) {
			int day = task[i][0];
			int pay = task[i][1];
			
			for(int j=0;j<i;j++) {
				d[i] = Math.max(pay+d[j], d[i]);
			}
		}
		
		Arrays.sort(d);
		
		System.out.println(d[T-1]);

	}
}