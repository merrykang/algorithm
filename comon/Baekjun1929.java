import java.io.*;
import java.util.*;

/**
 * 백준 1929 class2 : 소수 구하기
 */

public class Baekjun1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();  // 한 번에 출력하기 위해 선언
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        // 에라토스테네스의 체 알고리즘 구현 결과를 담을 배열​
        // 소수 판별 배열 N까지 나타내기위해 범위는 N+1로
        // type은 boolean이 아닌 int 또는 string도 가능
        // 0과 1은 소수가 아님
        boolean[] notPrime = new boolean[n + 1];
        notPrime[0] = notPrime[1] = true;

        // 에라토스테네스의 체 알고리즘
        for (int i = 2; i * i <= n; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j <= n; j += i) notPrime[j] = true;  // 제곱 수부터 그 수의 배수만큼 커지면서 소수 판별
            }
        }

        for (int i = m; i <= n; i++) {
            if (!notPrime[i]) sb.append(i).append('\n');
        }

        System.out.print(sb);

        // 문풀 2: 정답 맞춘 최초 코드
        // boolean[] notPrime = new boolean[n+1];  // 에라토스테네스의 체 알고리즘 실행 결과 넣을 배열
        // notPrime[0] = true;
        // notPrime[1] = true;
        // for (int i=2; i*i<=n; i++) {  // Q. i<=Math.sqrt(n) 은 안 되나?  A. 가능하지만 비효율적. 단순 곱셈보다 메서드 호출이 훨씬 시간이 많이 든다
        //     // Q. 소수인지 아닌지 어떻게 따져?  !prime[i]
        //     if (!notPrime[i]) {
        //         // 소수 아닌 것들 판명
        //         for (int j=i*i; j<=n; j+=i) {
        //             // Q. 반복적으로 배수 어떻게 true 처리 해줘?  A. j+= i 하여 j를 i만큼 키워나간다
        //             notPrime[j] = true; 
        //         }
        //     }
        // }
        // for (int i=m; i<=n; i++) {
        //     if (!notPrime[i]) sb.append(i).append('\n');
        // }
        // System.out.print(sb);


        // 문풀 1: 단순히 2, 3, 5, 7을 나누어 소수 계산하려고 했음. 하드 코딩
        // for (int i=m; i<=n; i++) {
        //     if (i==1 || i==2 || i==3 || i==5 || i==7) {
        //         sb.append(i).append('\n');
        //         continue;
        //     }
        //     if (i%2!=0 && i%3!=0 && i%5!=0 && i%7!=0) {
        //         sb.append(i).append('\n');
        //     }
        // }
        // System.out.print(sb);
    }
}

// public class Main {
// }