package b14000;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main_14226 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dp = new int[2*n+1];

		System.out.println(bfs(n));
	}
	
	static int bfs(int s) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {1, 0, 0});
		
		Set<String> visited = new HashSet<>();
		visited.add("1,0");
		while(!q.isEmpty()) {
			int[] state = q.poll();
			int cur = state[0];
			int clip = state[1];
			int time = state[2];
			
			if(cur == s) {
				return time;
			}
			
			if (!visited.contains(cur + "," + cur)) {
                visited.add(cur + "," + cur);
                q.add(new int[]{cur, cur, time + 1});
            }

            // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
            if (clip > 0 && cur + clip <= 1000 && !visited.contains((cur + clip) + "," + clip)) {
                visited.add((cur + clip) + "," + clip);
                q.add(new int[]{cur + clip, clip, time + 1});
            }

            // 3. 화면에 있는 이모티콘 중 하나를 삭제
            if (cur > 1 && !visited.contains((cur - 1) + "," + clip)) {
                visited.add((cur - 1) + "," + clip);
                q.add(new int[]{cur - 1, clip, time + 1});
            }
		}
		
		return -1;
	}

}
