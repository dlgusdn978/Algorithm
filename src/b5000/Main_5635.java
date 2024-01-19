package b5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_5635 {

	static class Person{
		String name;
		int day;
		int month;
		int year;
		public Person(String name, int day, int month, int year) {
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		Person[] arr = new Person[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			arr[i] = new Person(name, day, month, year);
		}
		
		Arrays.sort(arr, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.year==o2.year ? (o1.month==o2.month ? (o1.day-o2.day): o1.month-o2.month) : o1.year-o2.year;
			}
		});
		System.out.println(arr[n-1].name);
		System.out.println(arr[0].name);
	}

}
