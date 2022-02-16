import java.util.*;

class Solution {
	
	/**
	 * 들어온 문자열 내에서 순열을 돌려서 소수라면 Set에 넣는다.(중복제거)
	 */

    static int N,R;
    static boolean[] isSelected;
    static char[] choosed;
    static Set<Integer> set = new HashSet<>();
    static String input;

    public int solution(String numbers) {
        int answer = 0;

        input = numbers;
        N = numbers.length();
        isSelected = new boolean[N];        

        for(int i=1;i<=N;i++) {
            R = i;
            choosed = new char[R];
            permutation(0, 0);
        }

        answer = set.size();

        return answer;
    }

    public static void permutation(int cnt, int flag) {
        if(cnt == R) {
            String s = "";
            s = String.valueOf(choosed);
            System.out.println(s);
            if(isPrime(s)) set.add(Integer.parseInt(s));
            return;
        }

        for(int i=0;i<N;i++) {
            if((flag & 1<<i)!=0) continue;

            choosed[cnt] = input.charAt(i);
            permutation(cnt+1, flag | 1 << i);
        }
    }   

    static boolean isPrime(String s) {
        int number = Integer.parseInt(s);
        if(number == 1 || number == 0) {
            return false;
        }

        for(int i=2;i<number;i++) {
            if(number % i == 0) {
                return false;
            }
        }

        return true;
    }
}