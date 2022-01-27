package String;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class String_11656 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		String [] strArr;
		
		str = br.readLine();
		strArr = new String[str.length()];
		
		// 하나씩 잘라서 strArr에 저장
		for(int i=0; i<strArr.length; i++) {
			strArr[i] = str.substring(i,str.length());
		}
		
		Arrays.sort(strArr);  // 정렬
		
		for(String result : strArr) {
			System.out.println(result);
		}
		
	}

}
