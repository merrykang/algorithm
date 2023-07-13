import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");		
		int N = Integer.parseInt(st.nextToken());
		
		// 사각형을 2차원 배열로 받기 
		int [][] arr = new int[101][101];
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int si = Integer.parseInt(st.nextToken());
			int sj = Integer.parseInt(st.nextToken());
			for (int i=si; i<si+10; i++) {  
				for (int j=sj; j<sj+10; j++) {
				arr[i][j] =1;  
			}
		}
		}
		// 사각형 넓이 구하기: 배열의 모든 요소의 합 
		int area = 0;
		for (int [] lst: arr) {
			for (int n : lst) {
				area += n;
			}
		}
		System.out.println(area);
	}

}
