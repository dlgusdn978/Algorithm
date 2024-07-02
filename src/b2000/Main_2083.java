package b2000;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2083 {

	static class Member{
		String name;
		String type;
		public Member(String name, String type) {
			this.name = name;
			this.type = type;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Member> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		String str = "";
		while(!(str=sc.nextLine()).split(" ")[0].equals("#")) {
			String[] info = str.split(" ");
			String name = info[0];
			int age = Integer.parseInt(info[1]);
			int weight = Integer.parseInt(info[2]);
			if(age>17 || weight>=80) list.add(new Member(name, "Senior"));
			else list.add(new Member(name, "Junior"));
		}
		
		for(Member m : list) {
			sb.append(m.name+" "+m.type).append("\n");
		}
		System.out.println(sb.toString());

	}

}
