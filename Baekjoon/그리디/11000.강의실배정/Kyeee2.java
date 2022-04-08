import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static class Room implements Comparable<Room> {
		int start, end;
		
		public Room(int s, int e) {
			this.start = s;
			this.end = e;
		}

		@Override
		public int compareTo(Room o) {
			if(this.start == o.start) {
				return Integer.compare(this.end, o.end);
			} else {
				return Integer.compare(this.start, o.start);
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		
		int N = Integer.parseInt(br.readLine());
		Room [] rooms = new Room [N];
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			Room room = new Room(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
			rooms[i] = room;
		}
		
		Arrays.sort(rooms);
		
		int cnt = 0; // 강의실 개수
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		int endTime = 0;
		for(Room room: rooms) {
			endTime = room.end;
			
			if(!pQ.isEmpty() && pQ.peek() <= room.start) {
				pQ.poll();
			}
			
			pQ.add(endTime);
		}
		
		System.out.println(pQ.size());
	}

}
