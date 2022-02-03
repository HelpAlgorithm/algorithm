package algorithm_practice.Baekjoon.Sort;

import java.io.*;
import java.util.*;
 
public class Sort_2_10825 {

	static int N;

	public static class Student implements Comparable<Student> {
		String name; 
		int kor,eng,math;

		public Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}

		@Override
		public int compareTo(Student std) {
			if(this.kor < std.kor) { // 국어 - 오름차순
				return 1;
			}
			else if(this.kor == std.kor) { // if 국어 점수 동일
				if(this.eng > std.eng) { // 영어 - 내림차수
					return 1;
				}
				else if(this.eng == std.eng) { // if 영어 점수 동일
					if(this.math < std.math){ // 수학-  오름차순
						return 1;
					}
					else if(this.math == std.math) { // if 수학 점수 동일
						if(this.name.compareTo(std.name) > 0) { // 이름 - 내림차순
							return 1;
						}
					}
				}
			}
			return -1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ArrayList<Student> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String Name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			list.add(new Student(Name, kor, eng, math));
		}
		Collections.sort(list);
		
		for (int i = 0; i < N; i++) {
			System.out.println(list.get(i).name);
		}
	}
}