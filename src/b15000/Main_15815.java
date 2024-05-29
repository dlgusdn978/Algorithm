package b15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_15815 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        String str = br.readLine();
	        
	        Stack<Integer> stack = new Stack<>();
	        
	        for (int i = 0; i < str.length(); i++) {
	            char cur = str.charAt(i);
	            
	            if (Character.isDigit(cur)) {
	                // ���ڸ� ���ÿ� �ֱ�
	                stack.push(cur - '0');
	            } else {
	                // �����ڸ� ������ ���ÿ��� ���� �� ���� ���� ����
	                int b = stack.pop();
	                int a = stack.pop();
	                int result = 0;
	                
	                switch (cur) {
	                    case '+':
	                        result = a + b;
	                        break;
	                    case '-':
	                        result = a - b;
	                        break;
	                    case '*':
	                        result = a * b;
	                        break;
	                    case '/':
	                        result = a / b;
	                        break;
	                }
	                
	                // ���� ����� ���ÿ� �ٽ� �ֱ�
	                stack.push(result);
	            }
	        }
	        
	        // ���ÿ� �����ִ� ��� ���
	        System.out.println(stack.pop());

	}
	


}
