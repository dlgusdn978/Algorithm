package b21000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_21314 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���� ����.....?
		// ���� ū �� = m, k�� �����ϴ� ���� �� ���յ��� ����.
		// ���� ���� �� = �ִ��� m���� �����ϵ�, k�ʹ� �и��ϴ� ���յ��� ����.
		// String ���� split()�Լ� ����
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		List<String> maxList= new ArrayList<>();
		List<String> minList = new ArrayList<>();
		String subStr = "";
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='K') {
				if(!subStr.equals(""))minList.add(subStr);
				minList.add("K");
				subStr+="K";
				maxList.add(subStr);
				subStr="";
			}else {
				subStr+="M";
			}
			
		}
		if(subStr.length()!=0) {
			maxList.add(subStr);
			minList.add(subStr);
		}

		// K�� ������ ���� �и��ؼ� �����ϴ°� �ִ밪�� ����.
		String maxStr = "";
		String minStr = "";
		for(String s : maxList) {
			maxStr += getMaxString(s);
		}
		
		for(String s : minList) {
			minStr += getMinString(s);
		}
		
		System.out.println(maxStr);
		System.out.println(minStr);

	}

	static String getMaxString(String str) {
		String temp = "";
		if(str.charAt(str.length()-1)=='K') {
			temp+="5";
			for(int i=0; i<str.length()-1; i++) {
				temp+="0";
			}
		}else {
			for(int i=0; i<str.length(); i++) {
				temp+="1";
			}
		}
		return temp;
	}
	static String getMinString(String str) {
		String temp = "";
		if(str.equals("K")) {
			temp+="5";
		}else {
			temp+="1";
			for(int i=0; i<str.length()-1; i++) {
				temp+="0";
			}
		}
		return temp;
	}
}
