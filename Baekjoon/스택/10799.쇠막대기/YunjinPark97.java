import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int count = 0;
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				count++;
			}
			else {
				count--;
				if (str.charAt(i-1) == '(') {
					sum += count;
				}else {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}
}