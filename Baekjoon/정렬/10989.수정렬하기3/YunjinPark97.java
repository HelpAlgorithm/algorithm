package sorting;
/*
 * bw는 메모리 차지를 안하네?
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon10989_수정렬하기3 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int[] count = new int[10001];
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			count[Integer.parseInt(br.readLine())] += 1;
		}
		for (int i = 1; i < 10001; i++) {
			for (int j = 0; j < count[i]; j++) {
				bw.write(i+"\n");
			}
		}
		bw.flush();
}
}
