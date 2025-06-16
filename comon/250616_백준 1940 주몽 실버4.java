import java.io.*;
import java.util.*;

/**
 * 개선된 버전
 * 1. stream 사용하여 StringTokenizer 제거
 * 2. 로직 개선: end를 처음부터 시작하지 말고 끝에서부터 시작 -> start와 end를 중간으로 오도록 만들기
 *  - 이렇게 하면 index out of bound 에러 걱정하여 end == n-1 조건 안 따져도 됨
 *  - 이렇게 하면 조건문에서 start, end 만 조정하면 되어서 init 메서드 안 써도 됨
 * 3. 
 */
public class Main {
    // static int start = 0; static int end = 1; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        // 재료들을 정수 배열로 받기
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int[] materials = new int[n];
        int[] materials = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
        // for (int i=0; i<n; i++) materials[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(materials);

        // 투 포인터를 사용하여 materials 를 탐색
        // 반복마다 sum을 업데이트 하며, sum = m 인 경우 카운트
        int start = 0; int end = n-1;
        int sum = 0; int ans = 0;
        while (start < end) {
            sum = materials[start]+materials[end];
            if (sum==m) {
                ans++; 
                start++;
                end--;
            } else if (sum<m) start++;
            else end--;
        }

        // 정답 출력
        System.out.println(ans);
    }

}

// public class Main {
//     static int start = 0; static int end = 1; 

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         int m = Integer.parseInt(br.readLine());
        
//         // 재료들을 정수 배열로 받기
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int[] materials = new int[n];
//         for (int i=0; i<n; i++) materials[i] = Integer.parseInt(st.nextToken());
//         Arrays.sort(materials);

//         // 투 포인터를 사용하여 materials 를 탐색
//         // 반복마다 sum을 업데이트 하며, sum = m 인 경우 카운트
//         int sum = 0; int ans = 0;
//         while (start < n-1) {
//             sum = materials[start]+materials[end];
//             if (sum==m) {
//                 ans++; 
//                 init();
//             } else if (end == n-1) init();
//             else if (sum<m) end++;
//             else if (sum>m) init();
//         }

//         // 정답 출력
//         System.out.println(ans);
//     }

//     static void init() {
//         start++;
//         end = start+1;
//         return;
//     }
// }
