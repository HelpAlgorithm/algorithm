package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Chiyongs {

	static int[][] gears;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		gears = new int[4][8];
		
		for(int i=0;i<4;i++) {
			String input = br.readLine();

			for(int j=0;j<8;j++) {
				gears[i][j] = input.charAt(j) - '0';
			}
			
		}
		
		int K = Integer.parseInt(br.readLine());
		
		int answer = 0;
		for(int k=0;k<K;k++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int gear_num = Integer.parseInt(st.nextToken()) -1 ;
			int dir = Integer.parseInt(st.nextToken());
			
			compareL(gear_num-1, gear_num, dir);
			compareR(gear_num+1, gear_num, dir);
			rotate(gear_num, dir);
			
		}
		
		if(gears[0][0] == 1) answer+= 1;
		if(gears[1][0] == 1) answer+= 2;
		if(gears[2][0] == 1) answer+= 4;
		if(gears[3][0] == 1) answer+= 8;
		
		System.out.println(answer);

	}
	
	private static void compareL(int left, int me, int dir) {
		if(left == -1) return;
				
		if(gears[me][6] != gears[left][2]) {
			compareL(left-1, me-1, (dir == 1 ? -1 : 1));
			rotate(left, (dir == 1 ? -1: 1));
		}
	}
	
	private static void compareR(int right, int me, int dir) {
		if(right == 4) return;
		if(gears[me][2] != gears[right][6]) {
			compareR(right+1, me+1, (dir == 1 ? -1 : 1));
			rotate(right, (dir == 1 ? -1 : 1));
		}
	}
	
	private static void rotate(int num, int dir) {
		if(dir == 1) {
			int temp = gears[num][7];
			for(int i=7;i>0;i--) {
				gears[num][i] = gears[num][i-1];
			}
			gears[num][0] = temp;
		} else if(dir == -1) {
			int temp = gears[num][0];
			for(int i=0;i<7;i++) {
				gears[num][i] = gears[num][i+1];
			}
			gears[num][7] = temp;
		}
	}

}
