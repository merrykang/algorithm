/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int num, limit,result;
	static int val[], weight[],dp[][];
	
	static int knapsack(int idx, int remain) {
		if(idx==num) return 0;
		int temp = dp[idx][remain];
		if(temp!=-1) return temp;
		if(weight[idx]<=remain) 
			temp = knapsack(idx+1,remain-weight[idx])+val[idx];
		temp = Math.max(temp, knapsack(idx+1,remain));
		result = Math.max(result, temp);
		return dp[idx][remain]=temp;	
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=test;t++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			num = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			result=0;
			val = new int[num];
			weight = new int[num];
			dp = new int[num][limit+1];
			for(int i=0;i<num;i++) {
				String str = br.readLine();
				StringTokenizer st2 = new StringTokenizer(str);
				val[i] = Integer.parseInt(st2.nextToken());
				weight[i] = Integer.parseInt(st2.nextToken());
				for(int j=0;j<=limit;j++)
					dp[i][j]=-1;
			}
			knapsack(0,limit);
			System.out.println("#"+t+" "+result);
		}
	}
}