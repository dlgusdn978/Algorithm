package b20000;

import java.util.Scanner;

public class Main_20942 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double money = sc.nextDouble();
		
		System.out.println((int)(money/100*78) + " " + (int)(money-(money/5/100)*22));

	}

}
