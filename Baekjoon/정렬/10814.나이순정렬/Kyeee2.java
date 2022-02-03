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
			
			int age = Integer.parseInt(tokens.nextToken());
			String name = tokens.nextToken();
			students.add(new Student(age, name));
		}
		
		Collections.sort(students, (stu1, stu2) -> Integer.compare(stu1.age, stu2.age));
		
		StringBuilder sb = new StringBuilder();
		for(Student stu: students) {
			sb.append(stu.age + " " + stu.name).append('\n');
		}
		System.out.println(sb);
		
	}
	
}

class Student {
	int age;
	String name;
	
	public Student(int age, String name) {
		this.age = age;
		this.name = name;
	}
}
