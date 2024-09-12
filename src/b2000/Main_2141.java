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
		// ����
		// ����� ���� ���� distance ������ �۾���.
		// �׷��� ������ ����� ���� ���� ���� ������ ���� �����
		// mid���� �Ÿ� ���̰� ���� ���� ������ �����ϰ�,
		// �Ÿ����� ���ٸ� ��ȣ�� ���� �������.
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
