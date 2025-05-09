/**
 * 두번째 문풀
 */
import java.util.*;
import java.io.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         // 1. 어떻게 데이터 받을지에 따라 타입 정의 (중요)
//         TreeMap<Integer, Set<String>> sortedStr = new TreeMap<>();
        
//         // 2. treemap에서 같은 인덱스가 있어도 value가 대체되지 않고, 해당 인덱스에 value를 추가
//         // 3. value의 중복 제거 및 알파벳 기준 정렬 (TreeSet)
//         /** Q. map 안의 map 정렬하는 방법?
//             A. map 안의 map 이 있을 때: Map<String, Map<Integer, Integer>> 같은 형태의 중첩된 맵이 있을 때
//             > 1) 바깥 Map을 정렬: 기본적으로 HashMap은 정렬되지 않으므로 TreeMap 또는 LinkedHashMap을 활용하여 정렬
//             > 2) 바깥 Map을 Value(내부 Map 크기) 기준으로 정렬: List<Map.Entry<K, V>> 변환 후 정렬
//         */
//         for (int i=0; i<n; i++) {
//             String str = br.readLine();
//             sortedStr.computeIfAbsent(str.length(), k -> new TreeSet<>()).add(str);
//         }
        
//         // 4. 출력: TreeMap 순회하여 정렬된 결과 출력
//         // 만약 Entry만 단독 사용하고 싶다면 import java.util.Map.Entry; 해주어야 함
//         for (Map.Entry<Integer, Set<String>> entry : sortedStr.entrySet()) {
//             for (String word : entry.getValue()) System.out.println(word);
//         }
//     }
// }

/**
 * 첫 번째 문풀
 */
// import java.util.*;
// import java.util.Map.Entry;
// import java.io.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         // Map<Integer, TreeMap<Integer, String>> sortedStr = new HashMap<>();
//         // TreeMap<Integer, String> sortedStr = new TreeMap<>();
//         // TreeMap<Integer, List<String>> sortedStr = new TreeMap<>();
//         // 1. 어떻게 데이터 받을지에 따라 타입 정의 (중요)
//         TreeMap<Integer, Set<String>> sortedStr = new TreeMap<>();
        
//         // Q. map 안의 map 정렬하는 방법?
//         // while(n-->0) {
//         // TreeMap<Integer, String> tempStr = new TreeMap<>();
//         for (int i=0; i<n; i++) {
//             String str = br.readLine();
//             // TreeMap<Integer, String> tempStr = new TreeMap<>();
//             // sortedStr.put(str.length(), str);  //str.length() 얘가 인덱스 처럼 작용해서 1개 밖에 안 들어감. 따라서 인덱스를 별도로 만들어줘야함
//             // 2. treemap에서 같은 인덱스가 있어도 value가 대체되지 않고, 해당 인덱스에 value가 추가되는 방법
//             // sortedStr.computeIfAbsent(str.length(), k -> new ArrayList<>()).add(str);
//             // 3. value의 중복 제거 및 알파벳 기준 정렬 (TreeSet)
//             // 따라서 3. value를 기준으로 오름차순 정렬: entrySet으로 변경하여 수정 할 필요 없음
//             sortedStr.computeIfAbsent(str.length(), k -> new TreeSet<>()).add(str);
//             // sortedStr.put(i, tempStr);
//         }
//         // System.out.println(sortedStr);
//         // 3. value를 기준으로 오름차순 정렬: entrySet으로 변경하여 수정
//         // List<Map.Entry<Integer, Set<String>>> sortedEntries = new ArrayList<>(sortedStr.entrySet());
//         // // 아래 코드 개꼼꼼하게 분석할 것
//         // sortedEntries.sort(Comparator.comparing(e -> e.getValue().stream().min(String::compareTo).orElse("")));
//         // System.out.println(sortedEntries);
//         // 4. 출력
//         // **TreeMap 순회하여 정렬된 결과 출력**
//         for (Entry<Integer, Set<String>> entry : sortedStr.entrySet()) {
//             for (String word : entry.getValue()) {
//                 System.out.println(word);
//             }
//         }
//         // for (int i=0; i<sortedStr.size(); i++) {
//         //     Set<String> tempStr = sortedStr.get(i);  // String[] 이 아니라 Set<String>으로 받아야함
//         //     for (String word : tempStr) System.out.println(word);
//         // }
//     }
// }