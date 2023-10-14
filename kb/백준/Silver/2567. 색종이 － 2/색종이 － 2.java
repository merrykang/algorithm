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
		
		// 사각형을 배열로 받기 
		int[][] arr = new int[102][102];
		for (int n=0; n<N;n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int si = Integer.parseInt(st.nextToken());
			int sj = Integer.parseInt(st.nextToken());
			
			for (int i=si; i<si+10; i++) {
				for (int j=sj; j<sj+10; j++) {
					arr[i][j] =1;
				}
			}
		}
		
		// 사각형 둘레 계산 
		// 1. 방향 체크 
		int ans = 0;
		int [] di = {-1, 1, 0,0}; // 상, 하
		int [] dj = {0, 0, -1,1}; // 좌, 우
		for(int i=1; i<=100; i++) {
			for (int j=1; j<=100; j++) {
		// 2. next i, j로 arr[i][j] 네방향 체크 
				if (arr[i][j]==1) {
					for (int k=0; k<4; k++) {
						int ni = i+di[k];
						int nj = j+dj[k];	
						if(arr[ni][nj] == 0) ans++;
					}
					
				}
			}
		}
		System.out.println(ans);
	}
}
