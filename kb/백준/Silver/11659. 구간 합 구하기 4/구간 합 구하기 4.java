import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 배열 합 구하기 
		st = new StringTokenizer(br.readLine(), " ");
		int [] arrSum = new int[N+1];
		for (int n=1; n<=N; n++) {
			arrSum[n] = arrSum[n-1] + Integer.parseInt(st.nextToken());
		}
		
		// 구간 합 출력 
		StringBuilder sb = new StringBuilder();
		for (int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			sb.append(arrSum[E] - arrSum[S-1]).append('\n');  // for문 돌 때마다 줄바꿈 입력 
		}
		System.out.print(sb);
		}
}