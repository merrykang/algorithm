
// import java.io.*;
// import java.lang.reflect.Array;
// import java.util.*;

// // public class Main {
// //     public static void main(String[] args) throws Exception {
// //         System.out.println("Hello, World!");
// //     }
// // }

// // /**
// //  * 아래 코드도 시간 초과 발생
// //  * 기존의 조합으로 푸는 방식은 주석 처리하고 슬라이딩 윈도우로 풀어야함
// //  */

//  import java.io.*;
// import java.lang.reflect.Array;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int s = Integer.parseInt(st.nextToken());
//         int p = Integer.parseInt(st.nextToken());
 

//         // 1. dna 입력 받아 개수 세서 배열에 넣기
//         // Q. char로 받는 이유?
//         char[] dna = br.readLine().toCharArray();
//         // String[] dna = br.readLine().split("");  
//         // Arrays.sort(dna);  // A, C, G, T 순서대로 정렬

//         // 2. 꼭 들어 가야 하는 개수 받기. 
//         st = new StringTokenizer(br.readLine());
//         // Map<String, Integer> minCnt = new HashMap<>();
//         Map<Character, Integer> minCnt = new HashMap<>();
//         // String[] dnaStr = {"A", "C", "G", "T"};  // 여기서 [] 사용할 수 없는 이유?
//         char[] dnaChars = {'A', 'C', 'G', 'T'};  // 여기서 [] 사용할 수 없는 이유?
//         for (char c : dnaChars) minCnt.put(c, Integer.parseInt(st.nextToken()));
//         // for (int i=0; i<4; i++) {
//         //     minCnt.put(dnaStr[i], Integer.parseInt(st.nextToken()));
//         // }

//         // 2. 현재 윈도우에서 문자의 개수를 저장할 Map
//         Map<Character, Integer> currentCnt = new HashMap<>();
//         for (char c : dnaChars) currentCnt.put(c, 0);  // 일단 모두 0개로 초기 세팅

//         // 3. 슬라이딩 윈도우 초기 설정
//         int validCnt = 0;
//         for (int i=0; i<p; i++) {  // p개 문자열 뽑을거야
//             char c = dna[i];
//             // 1) currentCnt에 현재 dna 글자별로 각각 개수 세기
//             currentCnt.put(c, currentCnt.get(c)+1);
//         }
//         // 2) 각 조건들이 minCnt 조건 만족하는지 검사
//         // 이게 아예 dna에서 글자가 0개인 경우 체크하는 것 같음
//         if (isValid(currentCnt, minCnt)) validCnt++;

//         // 4. 슬라이딩 윈도우 (O(N))
//         for (int j=p; j<s; j++) {
//             char newChar = dna[j];
//             char oldChar = dna[j-p];
//             currentCnt.put(newChar, currentCnt.get(newChar)+1);
//             currentCnt.put(oldChar, currentCnt.get(oldChar)-1);
//             if (isValid(currentCnt, minCnt)) validCnt++;
//         }

//         // 4. combination 메서드 호출
//         // combination(dna, minCnt, 0, p, new ArrayList<>());
//         // System.out.println(ans.size());

//         // 5. 정답 출력
//         System.out.println(validCnt);
//     }

//     public static boolean isValid(Map<Character, Integer> currentCnt,Map<Character, Integer> minCnt) {
//         for (char key : minCnt.keySet()) {
//             if (currentCnt.get(key) < minCnt.get(key)) {  // null 일 경우는 생각 안 해도 되나?
//                 return false;
//             } 
//         }
//         return true;
//     }
// }


// /**
//  * 아래 코드가 시간 초과 발생
//  * 아래 코드는 백트래킹(재귀) + 가지치기로 푸는 방식
//  *  
//  */

// // public class Main {
// //     // static String[] dnaStr = {"A", "C", "G", "T"};
// //     // Q. 함수의 리턴 타입을 int 로 하고 ans를 return 하면 안 되는 이유
// //     static ArrayList<ArrayList<String>> ans = new ArrayList<>();
// //     static Map<String, Integer> combCnt = new HashMap<>();
// //     public static void combination(String[] dna, Map<String, Integer> minCnt, int start, int p, ArrayList<String> comb) {  // Q. 여기서 받는 타입을 List로 받는 이유?
// //         // 5. 종료 조건1: 조합 p개 원소를 모두 뽑은 경우
// //         // ArrayList<ArrayList<String>> ans = new ArrayList<>();
// //         if(comb.size() == p) {
// //             // if (!ans.contains(comb)) {
// //                 // ans.add(comb);
// //                 // System.out.println("comb: "+ comb);
// //                 // System.out.println("ans: "+ ans);
// //             // }
// //             // Map<String, Integer> combCnt = new HashMap<>();  // combination 메서드를 실행할 때마다 comCnt를 생성하는 것이 아니라 한 번만 생성하고 계속 값을 업데이트
// //             // for (String combStr : comb) {
// //             //     combCnt.put(combStr, combCnt.getOrDefault(combCnt, 0)+1);
// //             // }

// //             // 6. 종료 조건2: minCnt 조건 충족한 경우
// //             // combCnt의 getOrDefault 메서드 > minCnt 여야 함
// //             // boolean isValid = true;
// //             for (String minKey : minCnt.keySet()) {
// //                 if (combCnt.getOrDefault(minKey, 0) < minCnt.get(minKey)) {
// //                     // isValid = false;
// //                     // break;
// //                     return;
// //                 }
// //             }
// //             // if (isValid && !ans.contains(comb)) {
// //             ans.add(new ArrayList<>(comb)); // new ArrayList<>(comb)로 넣어야 하는 이유가 뭐야?
// //                 // System.out.println("ans: "+ans);
// //                 // System.out.println(ans.size());  // 언제 프린트,,?
// //             // }
// //             // System.out.println("combCnt: " + combCnt);
// //             // // Q. minCnt 개수 판별하는 방법?, 이거 진짜 모르겠음
// //             // for (String combStr : comb) {
// //             //     if (combCnt.get(combStr) >= minCnt.get(combStr)) {
// //             //         System.out.println("comb: "+ comb);
// //             //         ans++;  // 여기서 또 줄 세워서 개수 셀 수는 없잖아
// //             //     }
// //             // }
// //             return;
// //         }
// //         // 6. 조합 뽑기
// //         // Q. 여기에 minCnt 조건 추가 해서 뽑아야함. 어떻게 해? (각 조합(comb)에서 minCnt 조건을 만족하는지 검사 방법)
// //         for (int j=start; j<dna.length; j++) {  // Q. 왜 이만큼 반복하는지?
// //             String current = dna[j];
// //             // System.out.println("j: "+j);
// //             // System.out.println("dna[j]: "+dna[j]);
// //             // if (minCnt.get(dna[j]) > 0) {
// //             // if (minCnt.get(dna[j]) > 0 && !used.contains(dna[j])) {
// //             if (combCnt.getOrDefault(current, 0) < minCnt.getOrDefault(current, 0)) {
// //                 // used.add(dna[j]);  // 현재 원소를 선택한 것으로 표시
// //                 // comb.add(dna[j]);  // 현재 원소 추가
// //                 comb.add(current);  // 현재 원소 추가
// //                 combCnt.put(current, combCnt.getOrDefault(current, 0)+1);  // 실시간 개수 업데이트
// //                 combination(dna, minCnt, j+1, p, comb);  // 다음 원소 추가
// //                 comb.remove(comb.size()-1);  // 백트래킹(원상 복구): 마지막 원소 삭제 > Q. 이해 안 됨
// //                 combCnt.put(current, combCnt.get(current)-1);  // 개수 원복 > Q. 이해 안 됨
// //                 // System.out.println("used: "+used);
// //                 // used.remove(dna[j]);
// //             }
// //             // Q. 위처럼 원소 뽑을 때 중복 원소 제거하는 방법?  A. HashSet() 사용. (T, A)와 (A, T)는 다른 경우로 취급
// //         }
// //         // System.out.println(ans);
// //         // return;
// //     }
// //     public static void main(String[] args) throws IOException {
// //         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// //         StringTokenizer st = new StringTokenizer(br.readLine());
// //         int s = Integer.parseInt(st.nextToken());
// //         int p = Integer.parseInt(st.nextToken());
// //         // System.out.println("s: "+s);
// //         // System.out.println("p: "+p);

// //         // 1. dna 입력 받아 개수 세서 배열에 넣기
// //         // st = new StringTokenizer(br.readLine());  // Q. StringTokenizer는 안 되는 이유?  // Exception in thread "main" java.util.NoSuchElementException 발생
// //         String[] dna = br.readLine().split("");  // split은 string에 써야 한다
// //         // ArrayList<String> dna = new ArrayList<>();  // Q. ArrayList에 했을거면 어떻게 할 수 있었을지
// //         // dna.add(target.split(""));
// //         Arrays.sort(dna);  // A, C, G, T 순서대로 정렬
// //         // Map<String, Integer> dnaCnt = new HashMap<>();  // 이름별로 이미 오름차순 정렬되어 있으므로 HashMap 써도 됨
// //         // for (String str : dna) {
// //         //     // Q. 원소별로 개수 세는 java의 메서드가 있는지?
// //         //     // A. Java에는 배열 내 각 원소의 개수를 자동으로 세는 내장 메서드는 없음. 직접 구현해야함. 딱 봐도 키-값 관계이므로 Map이 가장 바람직함
// //         //     // put 메서드는 map에 쓰는거다!!
// //         //     // getOrDefault: str 키에 해당하는 값 가져오기. str 키에 해당하는 값 없으면 0으로 가져오고, 있으면 그 값에 1 더해서 다시 저장(put)
// //         //     dnaCnt.put(str, dnaCnt.getOrDefault(str, 0)+1);
// //         // }
// //         // System.out.println("dna: "+Arrays.toString(dna));
// //         // System.out.println("dnaCnt: "+dnaCnt);

// //         // 2. 꼭 들어 가야 하는 개수 받기. 
// //         st = new StringTokenizer(br.readLine());
// //         // int[] minCnt = new int[4];
// //         Map<String, Integer> minCnt = new HashMap<>();
// //         String[] dnaStr = {"A", "C", "G", "T"};  // 여기서 [] 사용할 수 없는 이유?
// //         for (int i=0; i<4; i++) {
// //         //     // minCnt[i] = Integer.parseInt(st.nextToken());
// //             minCnt.put(dnaStr[i], Integer.parseInt(st.nextToken()));
// //         //     // System.out.print(dnaCnt.get(dnaStr[i]));

// //         //     // 3. 각 위치에 해당하는 값이 minCnt < dnaCnt 이면 return 0;
// //         //     if (dnaCnt.get(dnaStr[i]) == null) dnaCnt.put(dnaStr[i], 0); 
// //         //     // if (minCnt.get(dnaStr[i]) == null) minCnt.put(dnaStr[i], 0); 
// //         //     if (minCnt.get(dnaStr[i]) > dnaCnt.get(dnaStr[i])) {
// //         //         System.out.println(0);  // Q. System.out.print(0); 을 실행하면 0%로 출력되는 이유?
// //         //         // System.out.print(dnaCnt.get(dnaStr[i]));
// //         //         return;
// //         //     }
// //         }
// //         // System.out.println("minCnt: "+Arrays.toString(minCnt));
// //         // System.out.println("minCnt: "+minCnt);

// //         // 4. combination 메서드 호출
// //         combination(dna, minCnt, 0, p, new ArrayList<>());
// //         System.out.println(ans.size());
// //         // System.out.println(combination(dna, 0, p, new ArrayList<>()));
// //     }
// // }
