import java.io.*;
import java.util.*;

/**
 * ✅ 올바른 접근 방법: 슬라이딩 윈도우 -> 배열을 한 번만 순회하면서 조건을 만족하는 가장 긴 부분 배열을 찾을 수 있습니다.
    1. 두 개의 포인터 start와 end를 사용하여 윈도우의 시작과 끝을 나타냅니다.
    2. end 포인터를 이동시키며 현재 윈도우에 포함된 과일의 종류를 Map을 사용하여 관리합니다.
    3. 윈도우 내 과일 종류가 2개를 초과하면 start 포인터를 이동시키며 과일을 제거하여 조건을 만족시킵니다.
    4. 각 단계에서 윈도우의 길이를 계산하여 최대값을 갱신합니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 탐색할 fruits 배열 입력 방법
        int[] fruits = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) fruits[i] = Integer.parseInt(st.nextToken());

        // 투 포인터로 탐색하기
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        for (int end=0; end<n; end++) {
            map.put(fruits[end], map.getOrDefault(fruits[end], 0)+1);
            // System.out.println("map1: "+ map);
            while(map.size() > 2) {
                map.put(fruits[start], map.getOrDefault(fruits[start], 0) - 1);
                // System.out.println("map 2: "+ map);
                if (map.get(fruits[start]) == 0) map.remove(fruits[start]);
                start++;
            }
            maxLength = Math.max(maxLength, end-start+1);
            // System.out.println("start: "+start);
            // System.out.println("end: "+end);
            // System.out.println("maxLength: "+maxLength);
            // System.out.println("=========================");
        }
        System.out.println(maxLength);
    }
}


/**
 * 아래 코드는 틀림
 *  - 이유: 이 문제는 투 포인터 + 슬라이딩 윈도우 형식으로 구현해야 하는데, 나는 양쪽 끝에서 가운데로 과일 종류를 제거하며 구현
 *  - 그러나 이러한 방식은 연속된 배열을 고려하지 않으므로 모든 경우를 탐색할 수 없음
 *  - 내가 위처럼 잘못 생각한 이유는 “과일 최대 개수”가 아니라 “연속된 최대 구간의 길이”가 문제의 본질임을 몰랐기 때문
 *  - 그래서 왜 슬라이딩 윈도우인가? 슬라이딩 윈도우는 이런 조건을 만족하는 가장 대표적인 알고리즘입니다:
        1. 포인터 두 개로 연속된 구간 유지
        2. 새로운 과일 등장 시 map.size() > 2 이면 왼쪽 포인터 이동
        3. 항상 연속 구간이므로 조건에 부합
 */
// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());

//         // map에 과일 탕후루별 개수 세기
//         // 탐색하기 위해 과일 탕후루 종류만 들어가 있는 배열 만들기
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int[] fruits = new int[n];
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int i=0; i<n; i++) {
//             int now = Integer.parseInt(st.nextToken());
//             fruits[i] = now;
//             map.put(now, map.getOrDefault(now, 0)+1);
//         }
//         // System.out.println("fruits: "+Arrays.toString(fruits));
//         // System.out.println("map: "+map);
//         // System.out.println("map.size(): "+map.size());

//         // 예외 처리: 과일 종류가 이미 2개 이하라면 n 출력하고 실행 종료 
//         if (map.size() <= 2) {
//             System.out.println(n);
//             return;
//         }

//         // 투 포인터
//         int ans = 0;
//         for (int i=0; i<n; i++) {
//             if (i > n/2) {
//                 // System.out.println("map 2: "+map);
//                 ans = 2;
//                 // for (int value : map.values()) {
//                 //     if (value > 0) ans += value;
//                 // }
//                 break;
//             }
//             // 왼쪽 것 지우고 해보기
//             map.put(fruits[i], map.getOrDefault(fruits[i], 0) -1);
//             if (map.get(fruits[i]) == 0) {
//                 map.remove(fruits[i]);
//                 if (map.size() == 2) {
//                     for (int value : map.values()) {
//                         ans += value;
//                     }
//                     break;
//                 } else {
//                     map.put(fruits[i], 1);
//                 }
//             }
//             map.put(fruits[n-i-1], map.getOrDefault(fruits[n-i-1], 0) -1);
//             if (map.get(fruits[n-i-1]) == 0) {
//                 map.remove(fruits[n-i-1]);
//                 if (map.size() == 2) {
//                     for (int value : map.values()) {
//                         ans += value;
//                     }
//                     break;
//                 } else {
//                     map.put(fruits[n-i-1], 1);
//                 }
//             }
//             map.put(fruits[i], map.getOrDefault(fruits[i], 0) -1);
//             map.put(fruits[n-i-1], map.getOrDefault(fruits[n-i-1], 0) -1);
//             // map.remove(fruits[i]);

//             // System.out.println("map.get(fruits[i]): "+map.get(fruits[i]));
//             // System.out.println("fruits[i]: "+fruits[i]);
//             // // if (i == n-i-1) continue;
//             // System.out.println("map.get(fruits[n-i-1]): "+map.get(fruits[n-i-1]));
//             // System.out.println("fruits[n-i-1]: "+fruits[n-i-1]);
//         }
//         System.out.println(ans);
//     }
// }
