package algorithm_me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		List<Student> students = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			
			String name = tokens.nextToken();
			int kor = Integer.parseInt(tokens.nextToken());
			int eng = Integer.parseInt(tokens.nextToken());
			int math = Integer.parseInt(tokens.nextToken());
			students.add(new Student(name, kor, eng, math));
		}
		
		Collections.sort(students, (stu1, stu2) -> {
			if(stu1.kor == stu2.kor) {
				if(stu1.eng == stu2.eng) {
					if(stu1.math == stu2.math) {
						return stu1.name.compareTo(stu2.name);
					} else {
						return Integer.compare(stu1.math, stu2.math) * -1;
					}
				} else {
					return Integer.compare(stu1.eng, stu2.eng);
				}
			} else {
				return Integer.compare(stu1.kor, stu2.kor) * -1;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(Student stu: students) {
			sb.append(stu.name).append('\n');
		}
		System.out.println(sb);
		
	}
	
}

class Student {
	String name;
	int kor, eng, math;
	
	public Student(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
}
