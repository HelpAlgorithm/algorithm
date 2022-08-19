import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Daeun {
    /* solution
     * 직사각형에 대각선을 그으면 x-1 개의 세로줄, y-1 개의 가로줄을 지난다.
     * 즉, 대각선이 그어진 타올의 수는 처음 선을 긋기 시작한 타올의 수를 더한  이라는 것을 알 수 있다.
     * 따라서 x + y - 최대공약수(x,y) 식 도출 가능 */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());


        System.out.println(x+y-gcd(x,y));
    }

    // 최대공약수
    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}