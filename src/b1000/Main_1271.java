package b1000;

import java.util.*;
import java.io.*;
import java.math.*;
// Online IDE - Code Editor, Compiler, Interpreter

public class Main
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger money = new BigInteger(st.nextToken());
        BigInteger people = new BigInteger(st.nextToken());
        System.out.println(money.divide(people));
        System.out.println(money.remainder(people));
    }
}

