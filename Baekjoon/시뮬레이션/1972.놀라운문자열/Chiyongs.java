package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author chiyongs
 * @since 2022. 7. 27.
 * @see https://www.acmicpc.net/problem/1972
 * @performance 13692	104
 * @category
 * @note
 */
public class BOJ_S3_1972_놀라운문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String input = br.readLine();

            if(input.equals("*")) {
                break;
            }

            boolean flag = false;

            List<String> list = new ArrayList<>();
            Set<String> set = new HashSet<>();
            for(int i=1;i<input.length();i++) {
                list.clear();
                set.clear();
                for(int j=0;j<input.length()-i;j++) {
                    // 그냥 input.charAt(j) + input.charAt(j+i)를 더해서 했더니 숫자가 더해져서 계속 틀림
                    String tmp = Character.toString(input.charAt(j)) + Character.toString(input.charAt(j+i));
                    set.add(tmp);
                    list.add(tmp);
                }

                if(set.size() != list.size()) {
                    flag = true;
                    break;
                }
            }

            if(flag) {
                System.out.println(input + " is NOT surprising.");
            } else {
                System.out.println(input + " is surprising.");
            }
        }
    }
}
