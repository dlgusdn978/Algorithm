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
	                // 숫자면 스택에 넣기
	                stack.push(cur - '0');
	            } else {
	                // 연산자를 만나면 스택에서 숫자 두 개를 꺼내 연산
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
	                
	                // 연산 결과를 스택에 다시 넣기
	                stack.push(result);
	            }
	        }
	        
	        // 스택에 남아있는 결과 출력
	        System.out.println(stack.pop());

	}
	


}
