import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int NA, NB, cnt;
	static int [] A, B;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		NA = Integer.parseInt(tokens.nextToken());
		NB = Integer.parseInt(tokens.nextToken());
		A = new int [NA];
		B = new int [NB];
		
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < NA; i++) {
			A[i] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < NB; i++) {
			B[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(A);
		Arrays.sort(B);
		
		for(int i = 0; i < NA; i++) {
			if(!binarySearch(A[i])) {
				cnt++;
				output.append(A[i] + " ");
			}
		}
		
		System.out.println(cnt);
		System.out.println(output);
	}

	private static boolean binarySearch(int num) {
		int start = 0, end = NB - 1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(B[mid] == num) return true;
			else if(B[mid] < num) start = mid + 1;
			else end = mid - 1;
		}
		
		return false;
	}

}
