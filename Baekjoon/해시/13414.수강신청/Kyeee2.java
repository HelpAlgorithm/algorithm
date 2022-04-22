import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int K, L;
	static Set<String> students = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		K = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		
		for(int i = 0; i < L; i++) {
			String nums = br.readLine();
			if(students.contains(nums)) students.remove(nums);
			students.add(nums);
		}
		
		int idx = 0;
		for(String num: students) {
			if(idx++ == K) break;
			output.append(num + "\n");
		}
		System.out.println(output);
	}

}
