package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Chiyongs {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
				
		String[][] s = new String[n][4];
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			s[i][0] = st.nextToken();
			s[i][1] = st.nextToken();
			s[i][2] = st.nextToken();
			s[i][3] = st.nextToken();
		}
		
		Arrays.sort(s, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[1].equals(o2[1])) {
					// 국어 점수가 같으면
					if(o1[2].equals(o2[2])) {
						// 영어 점수가 같으면
						if(o1[3].equals(o2[3])) {
							// 수학 점수가 같으면
							return o1[0].compareTo(o2[0]);
						} else {
							// 수학 점수가 감소
							return Integer.compare(Integer.parseInt(o1[3]),Integer.parseInt(o2[3])) * -1;
						}
					} else {
						// 영어 점수 증가
						return Integer.compare(Integer.parseInt(o1[2]),Integer.parseInt(o2[2]));
					}
				} else {
					// 국어 점수가 감소
					return Integer.compare(Integer.parseInt(o1[1]),Integer.parseInt(o2[1])) * -1;
				}				
			}
			
		});
		
		for(String[] row:s) {
			System.out.println(row[0]);
		}
	}
}
