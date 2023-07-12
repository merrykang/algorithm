import java.io.BufferedReader;
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
		
		// 2차원 배열 합 구하기
		int [][] arrSum = new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=N; j++) {
				arrSum[i][j] = arrSum[i][j-1] + arrSum[i-1][j] - arrSum[i-1][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		// 구간 합 구하기 
		StringBuilder sb = new StringBuilder();
		for (int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int si = Integer.parseInt(st.nextToken());
			int sj = Integer.parseInt(st.nextToken());
			int ei = Integer.parseInt(st.nextToken());
			int ej = Integer.parseInt(st.nextToken());
			sb.append(arrSum[ei][ej] - arrSum[ei][sj-1] - arrSum[si-1][ej] + arrSum[si-1][sj-1]).append('\n');
		}	
		System.out.println(sb);
		
	}

}