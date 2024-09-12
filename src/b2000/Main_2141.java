package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2141 {

	static class Village{
		int dist;
		int people;
		public Village( int dist, int people) {
			this.dist = dist;
			this.people = people;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		long totalPeople = 0;
		List<Village> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int dist = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());
			list.add(new Village(dist,people));
			totalPeople += people;
		}
		// 정리
		// 가운데에 있을 수록 distance 누적이 작아짐.
		// 그렇기 때문에 사람의 수가 가장 많은 마을이 여러 개라면
		// mid와의 거리 차이가 가장 작은 마을을 선택하고,
		// 거리마저 같다면 번호가 빠른 순서대로.
		Collections.sort(list, new Comparator<Village>() {
			@Override
			public int compare(Village o1, Village o2) {
				return o1.dist-o2.dist;
			}
		});
		long peopleSum = 0;
		
		for(Village a : list) {
//			System.out.println(a.dist);
			peopleSum += a.people;
			if(peopleSum>=(totalPeople+1)/2) {
				System.out.println(a.dist);
				break;
			}
		
		}

	} 

}
