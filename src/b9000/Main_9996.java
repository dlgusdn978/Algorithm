package b9000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_9996 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		/// asd*asdf
		/// asda*sdf
		/// as*sa
		/// asa
		/// left.length - compareStr.length< left.length => NE
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���ڿ��� ���� n
		int n = Integer.parseInt(br.readLine());
		
		// �� ���ڿ� str
		String[] str = br.readLine().split("\\*");
//		System.out.println(Arrays.toString(str));
		
		// ���� ��
		String leftStr = str[0];
		// ������ ��
		String rightStr = str[1];
		// ��� ���ڿ� compareStr
		for(int i=0; i<n; i++) {
			String compareStr = br.readLine();
			boolean flag = true;
//			System.out.println(compareStr.substring(0, leftStr.length()));
//			System.out.println(compareStr.substring(compareStr.length()-rightStr.length(), compareStr.length()));
			if(leftStr.length()+rightStr.length()>compareStr.length()) {
				flag = false;
			}else {
				if(!compareStr.substring(0, leftStr.length()).equals(leftStr)) flag = false;
				if(!compareStr.substring(compareStr.length()-rightStr.length(), compareStr.length()).equals(rightStr)) flag = false;
			}

			
			if(flag) System.out.println("DA");
			else System.out.println("NE");
		}
	}

}
