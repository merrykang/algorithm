import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// System.out.println("N을 입력하세요 >> ");
		int N = sc.nextInt();
		// System.out.println("배열을 입력하세요 >> ");
		int[] arr = new int[N]; 
		for (int i=0; i<N; i++) {
			arr[i] += sc.nextInt();
		}
		// System.out.println("v을 입력하세요 >> ");
		int v = sc.nextInt();
		
		int cnt = 0;  // v의 개수 
		for (int i=0; i<arr.length; i++) {
			if(arr[i] == v) cnt++;
		}
		System.out.println(cnt);;
	}

}