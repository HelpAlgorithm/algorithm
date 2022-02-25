import java.util.*;

class Solution {

    public String solution(int[] numbers){
        String answer = "";
        String[] str = new String[numbers.length];

        //int -> String
        for(int i = 0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }

        // 정렬
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b); // 문자열 기준으로 큰 순으로 넘기자
            }
        });

        if(str[0].charAt(0) =='0'){  // 0000 인 경우 0 만 출력하기
            answer = "0";
            return answer;
        }else{
            for(int i=0; i<str.length;i++){
                answer += Integer.parseInt(str[i]);
            }
        }
        return answer;
    }

// 선택정렬하면 1,2,3,6 통과못함 ㅎ;
// 생각해보니까 100,000 이면 O(N^2)이면 1억 넘어서 안되는듯..
//     public static void sort(){
//         int cnt = 0;

//         for(int i = 1 ; i < arr.length; i++){
//             first = Integer.toString(arr[i-1]);
//             last = Integer.toString(arr[i]);

//             if(Integer.parseInt(first+last) < Integer.parseInt(last+first)){
//                 int temp = arr[i-1];
//                 arr[i-1] = arr[i];
//                 arr[i] = temp;
//                 cnt ++;
//             }
//         }

//         if(cnt == 0){
//             return;
//         }
//         sort();
//     }
}