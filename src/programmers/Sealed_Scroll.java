package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sealed_Scroll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    public String solution(long n, String[] bans) {
	        String answer = "";
	        List<Long> list = new ArrayList<>();
	        for(int i=0; i<bans.length; i++){
	            list.add(getLongValue(bans[i]));
	        }
	        long idx = n + bans.length;
	        // 역순 정렬
	        Collections.sort(list);
	        Collections.reverse(list);
	        // list 처음부터 끝까지 탐색, 현재 값보다 크면 -- else break;
	        for(int i=0; i<list.size(); i++){
	            long cur = list.get(i);
	            if(idx<cur) idx--;
	            else break;
	        }

	        // getStr 수행
	        answer = getStr(idx);
	        return answer;
	    }
	    static String getStr(long val){
	        StringBuilder  sb = new StringBuilder();
	        while(val>0){
	            val--;
	            sb.append((char) ('a'+(val%26)));
	            val /= 26;
	        }
	        return sb.reverse().toString();
	    }
	    
	    static long getLongValue(String str){
	        long res = 0;
	        for(int i=0; i<str.length(); i++){
	            char ch = str.charAt(i);
	            long num = (long) ((int) ch - 96);
	            res += Math.pow(26, str.length()-i-1)*num;
	        }
	        return res+1;
	    }
	}
}
