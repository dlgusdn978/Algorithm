package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Max_Min {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public String solution(String s) {
	        List<Integer> list = new ArrayList<>();
	        String[] strs = s.split(" ");
	        for(int i=0; i<strs.length; i++){
	            list.add(Integer.parseInt(strs[i]));
	        }
	        Collections.sort(list);
	        String answer = "";
	        StringBuilder sb = new StringBuilder();
	        sb.append(list.get(0)+" ").append(list.get(list.size()-1));
	        answer = sb.toString();
	        return answer;
	    }
	}
}
