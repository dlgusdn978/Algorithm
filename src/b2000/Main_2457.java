package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2457 {
	static class Flower{
		int startDate;
		int endDate;
		public Flower(int startDate, int endDate) {
			this.startDate = startDate;
			this.endDate = endDate;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());

		int[] date = new int[366];

		List<Flower> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int startDate = dateToNumber(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			int endDate = dateToNumber(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			list.add(new Flower(startDate, endDate));
		}
		// 59~334
//		System.out.println(dateToNumber(12, 1));
		Collections.sort(list, new Comparator<Flower>() {
			@Override
			public int compare(Flower o1, Flower o2) {
				return o1.startDate==o2.startDate ? o2.endDate-o1.endDate : o1.startDate-o2.startDate;
			}
		});
		
		int cur = dateToNumber(3,1);
		int endLimit = dateToNumber(11,30);
		int count = 0;
		int index = 0;
		int maxEnd = 0;
		
		while(cur<=endLimit) {
			boolean found = false;
			while(index < n && list.get(index).startDate<=cur) {
				if(list.get(index).endDate>maxEnd) {
					maxEnd = list.get(index).endDate;
					found = true;
				}
				index++;
			}
			if(!found) {
				System.out.println(0);
				return;
			}
			cur = maxEnd;
			count++;
		}
		System.out.println(count);
	}
	
	static int dateToNumber(int month, int day) {
		int days = 0;
		for(int i=1; i<month; i++) {
			switch(i) {
			case 2:
				days+=28;
				break;
			case 4: case 6: case 9: case 11:
				days+=30;
				break;
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				days+=31;
			break;
			}
		}
		days+=day;
		return days;
	}

}
