package review;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10799{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(str);

        Stack<Character> stack = new Stack<>();

        int count = 0;
        boolean wasLeft = false;
        for(char c : str.toCharArray()){
            if(c=='(') {
                stack.push(c);
                wasLeft = true;
            }
            else{
                stack.pop();
                if(wasLeft){
                    count += stack.size();
                }else{
                    count++;
                }
                wasLeft = false;
            }
        }
        System.out.println(count);

    }
}