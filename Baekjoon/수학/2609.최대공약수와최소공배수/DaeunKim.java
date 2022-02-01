package algorithm_practice;

import java.util.Scanner;

public class DaeunKim {

   public static void main(String[] args) {
      int input1,input2;
      
      Scanner sc = new Scanner(System.in);
      input1 = sc.nextInt();
      input2 = sc.nextInt();

      System.out.println(getGCD(input1,input2));
      System.out.println(getLCM(input1,input2));
   
   }
   /* 최대공약수 */
   static int getGCD(int a, int b) {
      if(a % b ==0) {
         return b;
      }else {
         return getGCD(b,a%b); // a % b == 0 이 될 때까지 재귀함수 call
      } 
   }
   /* 최소공배수  */   
   static int getLCM(int a, int b) {
      return a * b / getGCD(a,b);   // a,b의 최소공배수 : a * b / 최대공약수 
   }
      

}