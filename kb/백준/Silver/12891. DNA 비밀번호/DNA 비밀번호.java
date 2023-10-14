import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int [] arrMin = new int[4];
	static int [] arrCnt = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 0. 값 입력 받기 
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
			// DNA 문자
		String [] arr = new String[S];  
		String input = (String) br.readLine();
		for (int s=0; s<S; s++) {
			arr[s] = String.valueOf(input.charAt(s));
		}
			// 문자 최소 개수  
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<arrMin.length; i++) {
			arrMin[i] = Integer.parseInt(st.nextToken());
		}
			// 만들 수 있는 비밀번호 개수 
		int ans = 0;
        
		// 1. 기준 문자열 선택하여 글자 종류별 카운트 
		for (int p=0; p<P; p++) {
			if(arr[p].equals("A")) arrCnt[0]++;
			if(arr[p].equals("C")) arrCnt[1]++;
			if(arr[p].equals("G")) arrCnt[2]++;
			if(arr[p].equals("T")) arrCnt[3]++;
		}
		if (checkCounting()) ans++;
		
		// 2. 투포인터 사용하여 부분 문자열 만들기  
		int i = -1;
		for (int j=P; j<S; j++) {
			i = j-P;
			// 이전 부분 문자열의 시작 문자 제외 
			if(arr[i].equals("A")) arrCnt[0]--;
			if(arr[i].equals("C")) arrCnt[1]--;
			if(arr[i].equals("G")) arrCnt[2]--;
			if(arr[i].equals("T")) arrCnt[3]--;
			// 이전 부분 문자열의 끝에서 시작 문자 추가
			if(arr[j].equals("A")) arrCnt[0]++;
			if(arr[j].equals("C")) arrCnt[1]++;
			if(arr[j].equals("G")) arrCnt[2]++;
			if(arr[j].equals("T")) arrCnt[3]++;
			if (checkCounting()) ans++;
		}
		System.out.println(ans);
	}
	// *. 최소 개수 판단하는 함수 만들기 
	public static boolean checkCounting() {
		for (int i=0; i<4; i++) {
			if(arrMin[i] > arrCnt[i]) return false;
		}
		return true;
	}
}