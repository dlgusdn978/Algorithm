package b17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_17413 {

	public static void main(String[] args) throws IOException {
		// �±״� �ܾ �ƴϴ�.
		// �±� �ٱ��� �ִ� �ܾ���� ������ reverse order
		// ������ �������� �ܾ ������ reverse
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		
//		System.out.println(Arrays.toString(arr));
		
		String str = "";
		// ��ȣ �ȿ� �ִ� ���ڿ����� üũ
		String temp = "";
		boolean flag = false;
		for(int i=0; i<arr.length;i++) {
			char cur = arr[i];

			if(flag) {
				// ��ȣ �ȿ� ���� ��
				if(cur=='>') {
					str+='<';
					for(int j=0; j<temp.length(); j++) {
						str+=temp.charAt(j);
					}
					str+='>';
					flag = false;
					temp="";
					continue;
				}
				temp+= cur;
			}else {
				// ��ȣ �ȿ� ���� ���� ��
				if(cur=='<') {
					for(int j=temp.length()-1; j>=0; j--) {
						str+=temp.charAt(j);
					}
					flag = true;
					temp="";
					continue;
				}else if(cur==' ') {
					for(int j=temp.length()-1; j>=0; j--) {
						str+=temp.charAt(j);
					}
					str+=" ";
					temp="";
					continue;
				}
				
				temp+=cur;
			}
		}
		for(int j=temp.length()-1; j>=0; j--) {
			str+=temp.charAt(j);
		}
		System.out.println(str);
	}

}
