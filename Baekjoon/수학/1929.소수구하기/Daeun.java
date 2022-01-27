package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math_1929 {
	public static void main(String[] args) throws IOException {
	   /* 에라토스테네스의 체 : 어떤 수의 소수 여부를 확인할 때, 특정 숫자의 '제곱근'까지만 약수가 있는지를 확인하면 된다
	    * N / N 은 (몫) 몫과 N 둘중 하나는 N의 제곱근 이하이기 때문 -> 대량의 소수를 한꺼번에 판별할 때 사용
	    * 
	    * 원리 ) 소수 판별 범위만큼  배열을 할당해, 값을 넣어주고 하나씩 지워나가는 방법 이용
	    * 1.  배열 생성 + 초기화
	    * 2. 2부터 시작해 특정 수의 배수에 해당하면 지운다 (자기 자신은 지우지 X, 이미 지워진 수 건너뛰기)
	    * 3. 2부터 시작해 남은 수 모두 출력
	    * */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		String N = br.readLine(); // 
		int start;
		int end;
		
		st = new StringTokenizer(N);
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		boolean prime[] = new boolean[end+1];
		
		// 소수는 false
	    // 1은 소수가 아니므로 제외
	    prime[0] = true;
	    prime[1] = true;
	    
	    for(int i=2; i<=Math.sqrt(end); i++) {	// 제곱근 까지만 약수가 있는지 확인
	    	for(int j=i*i; j<= end; j+=i) {	// END 까지 j 의 배수들을 전부 true로 만들어서 없애버리자!
	    		prime[j] = true;
	    	}
	    }
	
	    // 소수 출력 (start 지점부터 출력하면 됨)
	    for(int i=start; i<=end; i++){
	    	if(prime[i] == false) 
	    		System.out.println(i);        
	    }            
	        
	}
	
}
