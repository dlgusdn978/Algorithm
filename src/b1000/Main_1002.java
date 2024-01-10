package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1002 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			// 원 중심간의 거리와 각 원 반지름의 크기 합 비교
			// 중심간의 거리 > 반지름 합 => 0
			// 중심간의 거리 = 반지름 합 => 1
			// 중심간의 거리 < 반지름 합 => 2
			
			// 중심간의 거리
			double distance = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
//			System.out.println(distance);
			if(x1==x2 && y1==y2) {
				if(distance == Math.abs(r1-r2)) {
					System.out.println(-1);
				}else {
					System.out.println(0);
				}
	 		}else {
				if(distance>Math.abs(r1-r2) && distance<r1+r2) System.out.println(2);
				else if(distance==Math.abs(r1-r2) || r1+r2==distance) System.out.println(1);
				else System.out.println(0);
			}

		}

	}

}
