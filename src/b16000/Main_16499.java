package b16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main_16499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); 
		
		// ���ڿ� �Է� �ް�
		// �����Ѵ���
		// hash�� �ֱ�
		
		Set<String> set = new HashSet<>();
		
		for(int i=0; i<n; i++) {
			char[] temp = br.readLine().toCharArray();
			Arrays.sort(temp);
			String res = "";
			for(char a : temp) {
				res+=a;
			}
			set.add(res);
		}
		System.out.println(set.size());
	}

}
