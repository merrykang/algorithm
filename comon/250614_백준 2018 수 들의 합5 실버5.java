import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 탐색 대상인 연속된 자연수를 배열로 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for (int i=1; i<=n; i++) arr[i] = i; 

        // 투 포인터
        // end 인덱스가 n 과 같기 전까지 sum과 n의 크기 비교 후 sum을 업데이트
        // 정답(ans)은 n 자기 자신은 항상 n의 합과 같으므로 1개부터 시작
        // 현재 합계(sum)은 시작 인덱스가 1부터 시작하므로, 이미 더한 것으로 치고 시작하는 것이 좋음
        int start = 1; int end = 1; int ans = 1; int sum = 1;
        while (end != n) {
            if (sum==n) {  // 현재 연속된 자연수의 합이 n과 같을 때
                ans++;
                end++;  // end로 더해지는 수 확장
                sum += end;  // sum 업데이트
            } else if (sum<n) {  // 현재 연속된 자연수의 합이 n보다 작을 때 
                end++;  // end로 더해지는 수 확장
                sum += end;  // sum 업데이트
            } else {  // 현재 연속된 자연수의 합이 n보다 클 때 
                sum -= start;  // 현재의 start를 sum에서 제거
                start++;
            }
        }

        // 정답 출력
        System.out.println(ans);
    }
 }
