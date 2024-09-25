package b21000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_21608 {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static class Seat{
		int r, c, like, space;
		public Seat(int r, int c, int like, int space) {
			this.r = r;
			this.c = c;
			this.like = like;
			this.space = space;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		List<List<Integer>> friendList = new ArrayList<>();
		for(int i=0; i<=n*n; i++) {
			friendList.add(new ArrayList<>());
		}
		for(int i=0; i<n*n; i++) {
			st = new StringTokenizer(br.readLine());
			int studentNum = Integer.parseInt(st.nextToken());
			for(int j=0; j<4; j++) {
				friendList.get(studentNum).add(Integer.parseInt(st.nextToken()));
			}
			
			find(arr, friendList, studentNum);
		}
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				int count = 0;
				for(int k=0; k<4; k++) {
					int nr = i+dr[k];
					int nc = j+dc[k];
					if(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length) {
						if(friendList.get(arr[i][j]).contains(arr[nr][nc])) count++;
					}
				}
				if(count==0) sum += 0;
				else {
					sum += Math.pow(10, count-1);
				}
//				System.out.println(sum);
			}
		}
		System.out.println(sum);
	}
	
	static void find(int[][] arr, List<List<Integer>> friendList, int studentNum) {
		PriorityQueue<Seat> pq = new PriorityQueue<>(new Comparator<Seat>() {
			@Override
			public int compare(Seat o1, Seat o2) {
				return o2.like==o1.like ?  (o2.space==o1.space ? (o1.r==o2.r ? o1.c-o2.c : o1.r-o2.r) : o2.space-o1.space) : o2.like-o1.like;
			}
		});
		
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j]!=0) continue;
				int like = 0;
				int space = 0;
				for(int k=0; k<4; k++) {
					int nr = i+dr[k];
					int nc = j+dc[k];
					if(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length) {
						if(arr[nr][nc]==0) space++;
						else if(friendList.get(studentNum).contains(arr[nr][nc])) like++;
					}
				}
				pq.add(new Seat(i, j, like, space));
			}
		}
		Seat bestSeat = pq.poll();
		arr[bestSeat.r][bestSeat.c] = studentNum;
	}
}
