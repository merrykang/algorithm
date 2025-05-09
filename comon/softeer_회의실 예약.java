// // public class softeer_회의실 예약 {
    
// // }

// // 네 번째 문풀
// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int n = Integer.parseInt(st.nextToken());
//         int m = Integer.parseInt(st.nextToken());

//         // 1. 회의실 이름 입력 후 정렬
//         // 추후 List를 ArrayList, LinkedList, vertor 등 모든 List 구현체로 변경할 가능성을 고려하여 해당 유형으로 선언
//         // ArrayList<String> roomNames = new ArrayList<>();
//         List<String> roomNames = new ArrayList<>();
//         while(n-- > 0) roomNames.add(br.readLine());
//         Collections.sort(roomNames);

//         // 2. 각 회의실 예약 정보 입력
//         // Map<String, TreeMap<Integer, Integer>> rooms = new HashMap<>();
//         Map<String, List<int[]>> rooms = new HashMap<>();
//         while(m-- > 0) {
//             st = new StringTokenizer(br.readLine());
//             String roomName = st.nextToken();
//             int start = Integer.parseInt(st.nextToken());
//             int end = Integer.parseInt(st.nextToken());
//             // rooms.putIfAbsent(roomName, new TreeMap<>());
//             rooms.putIfAbsent(roomName, new ArrayList<>()); 
//             // rooms.get(roomName).put(start, end);
//             rooms.get(roomName).add(new int[]{start, end});
//         }

//         // 3. 예약 정보 오름차순 정렬 (시작 시간 기준)
//         // Q. Comparator ?
//         for (List<int[]> times : rooms.values()) {
//             times.sort(Comparator.comparingInt(a -> a[0]));
//         }

//         // 3. 회의실 예약 현황 체크 (핵심 로직)
//         StringBuilder sb = new StringBuilder();
//         for (int i=0; i< roomNames.size(); i++) {
//             String roomName = roomNames.get(i);
//             sb.append("Room ").append(roomName).append(":\n");
//             // 예외: 회의실은 존재하지만 예약 현황이 없는 경우
//             if(!rooms.containsKey(roomName)) {
//                 sb.append("1 available:\n09-18\n");
//             // 회의실이 존재하고 예약 현황이 있는 경우
//             } else {
//                 // TreeMap<Integer, Integer> roomTimes = rooms.get(roomName);
//                 List<int[]> roomTimes = rooms.get(roomName);
//                 // ArrayList<String> availableRooms = new ArrayList<>();
//                 List<String> availableRooms = new ArrayList<>();
//                 int lastEnd = 9; int cnt = 0;  // 사용 가능한 room 체크 횟수; cnt=0 이면 "Not available"

//                 // 4. 회의실 남는 시간 체크 (핵심 로직)
//                 // roomTimes의 타입을 List<int[]> 으로 선언함에 따른 변경
//                 // for (Map.Entry<Integer, Integer> entry : roomTimes.entrySet()) {
//                 for (int[] times : roomTimes) {
//                     // int currentStart = entry.getKey();
//                     int currentStart = times[0];
//                     if (currentStart > lastEnd) {
//                         availableRooms.add(String.format("%02d-%02d", lastEnd, currentStart));
//                         cnt++;
//                     }
//                     // 직전 원소 종료 시간 업데이트
//                     // lastEnd = entry.getValue(); 
//                     lastEnd = times[1];
//                 }
//                 // 마지막 원소이고 18시까지 시간이 남은 경우, 사용 가능한 룸 체크
//                 if (lastEnd < 18) {
//                     availableRooms.add(String.format("%02d-18", lastEnd));
//                     cnt++;
//                 }
    
//                 // 5. 정답 출력
//                 if (cnt==0) sb.append("Not available\n");
//                 else {
//                     sb.append(cnt).append(" available:\n");
//                     for (String room : availableRooms) sb.append(room).append("\n");
//                 }
//             }
//             // 마지막 원소가 아니라면 구분선 추가
//             if (i < roomNames.size()-1) sb.append("-----\n");
//         }
//         System.out.print(sb);
//     }
// }

// // 세 번째 문풀
// // import java.io.*;
// // import java.util.*;

// // public class Main {
// //     public static void main(String[] args) throws IOException {
// //         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// //         StringTokenizer st = new StringTokenizer(br.readLine());
// //         int n = Integer.parseInt(st.nextToken());
// //         int m = Integer.parseInt(st.nextToken());

// //         // 1. 회의실 이름 입력 후 정렬
// //         ArrayList<String> roomNames = new ArrayList<>();
// //         while(n-- > 0) roomNames.add(br.readLine());
// //         Collections.sort(roomNames);

// //         // 2. 각 회의실 예약 정보 입력
// //         Map<String, TreeMap<Integer, Integer>> rooms = new HashMap<>();
// //         while(m-- > 0) {
// //             // times 사용하지 않고 바로 start와 end를 put 하므로 별도의 변수 선언X
// //             // TreeMap<Integer, Integer> times = new HashMap<>();
// //             st = new StringTokenizer(br.readLine());
// //             String roomName = st.nextToken();
// //             int start = Integer.parseInt(st.nextToken());
// //             int end = Integer.parseInt(st.nextToken());
// //             rooms.putIfAbsent(roomName, new TreeMap<>()); 
// //             rooms.get(roomName).put(start, end);
// //         }

// //         // 3. 회의실 예약 현황 체크 (핵심 로직)
// //         StringBuilder sb = new StringBuilder();
// //         for (int i=0; i< roomNames.size(); i++) {
// //             String roomName = roomNames.get(i);
// //             sb.append("Room ").append(roomName).append(":").append("\n");
// //             // 예외: 회의실은 존재하지만 예약 현황이 없는 경우
// //             if(!rooms.containsKey(roomName)) {
// //                 // continue 사용 대신 if-else로 조건 명확하게 구분
// //                 // 줄바꿈 한 줄에 표현해도 된다
// //                 sb.append("1 available:\n09-18\n");
// //                 // sb.append("1 available:").append("\n");
// //                 // sb.append("09-18").append("\n");
// //                 // if (roomNames.indexOf(roomName) != roomNames.size()-1) sb.append("-----").append("\n");
// //                 // continue;
// //             // 회의실이 존재하고 예약 현황이 있는 경우
// //             } else {
// //                 // Q. Map(HashMap) vs TreeMap
// //                 // 곧바로 TreeMap으로 받아 오름차순 정렬
// //                 // 직전 코드는 map 을 TreeMap으로 변환하느라 new 선언했고, 원래는 걍 키-값 쌍만 받으면 됨
// //                 // Map<Integer, Integer> roomTimes = new TreeMap<>(rooms.get(roomName));
// //                 TreeMap<Integer, Integer> roomTimes = rooms.get(roomName);
// //                 ArrayList<String> availableRooms = new ArrayList<>();
// //                 int lastEnd = 9; int cnt = 0;  // 사용 가능한 room 체크 횟수; cnt=0 이면 "Not available"

// //                 // 4. 회의실 남는 시간 체크
// //                 // 마지막 원소를 체크해야 해서 ArrayList로 변환했었음
// //                 // 그러나 회의실 시간 반복문이 종료되고 lastEnd로 18시를 체크하면 됨
// //                 // 따라서 ArrayList 사용하지 않고, 인덱스 필요없는 for문 돌린다
// //                 // ArrayList<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(roomTimes.entrySet());
// //                 // for (int j=0; j<entryList.size(); j++) {
// //                 for (Map.Entry<Integer, Integer> entry : roomTimes.entrySet()) {
// //                     // Map.Entry<Integer, Integer> entry = entryList.get(j);
// //                     int currentStart = entry.getKey();
// //                     // 직전 원소 종료 시간과 현재 원소 시작 시간의 차이가 있을 경우, 사용 가능한 룸 체크
// //                     if (currentStart > lastEnd) {
// //                         // 결국 출력되는 값은 currentStart, lastEnd 모두 포맷팅된 값이므로 한 방에 String.format 사용
// //                         // String formattedLastEnd = String.format("%02d", lastEnd);
// //                         // availableRooms.add(formattedLastEnd + "-" + String.valueOf(currentStart));
// //                         availableRooms.add(String.format("%02d-%02d", lastEnd, currentStart));
// //                         cnt++;
// //                     }
// //                     // 직전 원소 종료 시간 업데이트
// //                     lastEnd = entry.getValue(); 
// //                     // 마지막 원소이고 18시까지 시간이 남은 경우, 사용 가능한 룸 체크
// //                 }
// //                 if (lastEnd < 18) {
// //                     // availableRooms.add(String.valueOf(lastEnd) + "-" + String.valueOf(18));
// //                     availableRooms.add(String.format("%02d-18", lastEnd));
// //                     cnt++;
// //                 }
    
// //                 // 5. 정답 출력
// //                 // StringBuilder 에서 구분선은 한 줄에 처리
// //                 // if (cnt==0) sb.append("Not available").append("\n");
// //                 if (cnt==0) sb.append("Not available\n");
// //                 else {
// //                     // sb.append(cnt).append(" available:").append("\n");
// //                     sb.append(cnt).append(" available:\n");
// //                     for (String room : availableRooms) sb.append(room).append("\n");
// //                 }
// //                 // 마지막 원소가 아니라면 구분선 추가
// //                 // if (i < roomNames.size()-1) sb.append("-----").append("\n");
// //             }
// //             if (i < roomNames.size()-1) sb.append("-----\n");
// //         }
// //         System.out.print(sb);
// //     }
// // }


// // 두 번째 문풀
// // import java.io.*;
// // import java.util.*;

// // public class Main {
// //     public static void main(String[] args) throws IOException {
// //         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// //         StringTokenizer st = new StringTokenizer(br.readLine());
// //         int n = Integer.parseInt(st.nextToken());
// //         int m = Integer.parseInt(st.nextToken());

// //         // 1. 회의실 이름 입력 후 정렬
// //         ArrayList<String> roomNames = new ArrayList<>();
// //         while(n-- > 0) roomNames.add(br.readLine());
// //         Collections.sort(roomNames);

// //         // 2. 각 회의실 예약 정보 입력
// //         Map<String, Map<Integer, Integer>> rooms = new HashMap<>();
// //         while(m-- > 0) {
// //             Map<Integer, Integer> times = new HashMap<>();
// //             st = new StringTokenizer(br.readLine());
// //             String roomName = st.nextToken();
// //             int start = Integer.parseInt(st.nextToken());
// //             int end = Integer.parseInt(st.nextToken());
// //             // treeMap으로 차후 정렬할 것 생각해서 처음부터 정렬
// //             rooms.putIfAbsent(roomName, new TreeMap<>()); 
// //             // rooms.putIfAbsent(roomName, new HashMap<>());  
// //             rooms.get(roomName).put(start, end);
// //         }

// //         // 3. 회의실 예약 현황 및 남는 시간 체크 (핵심 로직)
// //         StringBuilder sb = new StringBuilder();
// //         // 마지막 roomName인지 체크 필요하므로 인덱스 사용하는 for문 사용
// //         // for (String roomName : roomNames) {
// //         for (int i=0; i< roomNames.size(); i++) {
// //             String roomName = roomNames.get(i);
// //             sb.append("Room ").append(roomName).append(":").append("\n");
// //             // 예외: 회의실은 있으나 예약 현황이 없는 경우
// //             // if (rooms.get(roomName) == null) {
// //             if(!rooms.containsKey(roomName)) {
// //                 sb.append("1 available:").append("\n");
// //                 sb.append("09-18").append("\n");
// //                 if (roomNames.indexOf(roomName) != roomNames.size()-1) sb.append("-----").append("\n");
// //                 continue;
// //             }

// //             // 2) 예약 있는 룸의 경우
// //             Map<Integer, Integer> roomTimes = new TreeMap<>(rooms.get(roomName));
// //             int cnt = 0;  // 사용 가능한 room 체크 횟수; cnt=0 이면 "Not available"
// //             int lastEnd = 9;
// //             ArrayList<String> availableRooms = new ArrayList<>();
// //             ArrayList<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(roomTimes.entrySet());
// //             for (int j=0; j<entryList.size(); j++) {
// //                 Map.Entry<Integer, Integer> entry = entryList.get(j);
// //                 int currentStart = entry.getKey();
// //                 // 직전 원소 종료 시간과 현재 원소 시작 시간의 차이가 있을 경우, 사용 가능한 룸 체크
// //                 if (currentStart - lastEnd > 0) {  
// //                     String formattedLastEnd = String.format("%02d", lastEnd);
// //                     availableRooms.add(formattedLastEnd + "-" + String.valueOf(currentStart));
// //                     cnt++;
// //                 }
// //                 // 직전 원소 종료 시간 업데이트
// //                 lastEnd = entry.getValue(); 
// //                 // 마지막 원소이고 18시까지 시간이 남은 경우, 사용 가능한 룸 체크
// //                 if (j == entryList.size()-1 && 18 - lastEnd >0) {
// //                     availableRooms.add(String.valueOf(lastEnd) + "-" + String.valueOf(18));
// //                     cnt++;
// //                 }
// //             }

// //             // 3) 룸의 사용 가능 여부(정답) 출력
// //             if (cnt==0) sb.append("Not available").append("\n");
// //             else {
// //                 sb.append(cnt).append(" available:").append("\n");
// //                 for (String room : availableRooms) sb.append(room).append("\n");
// //             }
// //             // 마지막 원소가 아니라면 구분선 추가
// //             if (i < roomNames.size()-1) sb.append("-----").append("\n");
// //         }
// //         System.out.print(sb);
// //     }
// // }

// // 첫 번째 문풀
// // import java.io.*;
// // import java.util.*;

// // public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int n = Integer.parseInt(st.nextToken());
//         int m = Integer.parseInt(st.nextToken());
//         // System.out.print("n: "+n);

//         // 1. 회의실 이름 먼저 받아서 오름차순 정렬하기
//         ArrayList<String> roomNames = new ArrayList<>();
//         while(n-- > 0) {
//             roomNames.add(br.readLine());
//         }
//         Collections.sort(roomNames);
//         // System.out.print("roomNames: "+ roomNames);

//         // 2. 각 회의실 정보 받아서 회의실 명칭, 시간대로 오름차순 정렬
//         // Q. 각 회의실 정보 받는 형식? Map? 키, 값 쌍이 되어야 하니까 Map 이 맞지 않을까. A.yes
//         Map<String, Map<Integer, Integer>> rooms = new HashMap<>();
//         while(m-- > 0) {
//             // Q. 해당하는 회의실 명칭(키 값)에 따라 어떻게 회의실 시간 put 하지?
//             // Q. 이렇게 값 받으면 회의실 시간이 계속 대체됨. 그럼 어떻게 해? (핵심 로직)
//             // A. 1) 기존 roomName이 rooms 맵에 존재하는지 확인 : rooms.get(roomName)
//             // 2) 존재하면 기존 times 맵에 (start, end) 추가: putIfAbsent(roomName, new HashMap<>())
//             // 3) 존재하지 않으면 새로운 times 맵을 생성 후 rooms에 추가: putIfAbsent(roomName, new HashMap<>())
//             Map<Integer, Integer> times = new HashMap<>();
//             st = new StringTokenizer(br.readLine());
//             String roomName = st.nextToken();
//             int start = Integer.parseInt(st.nextToken());
//             int end = Integer.parseInt(st.nextToken());
//             rooms.putIfAbsent(roomName, new HashMap<>());
//             rooms.get(roomName).put(start, end);
//             // times.put(start, end);
//             // rooms.put(roomName, times);
//             // System.out.println("rooms: "+rooms);
//         }

//         // 3. rooms 돌면서
//         StringBuilder sb = new StringBuilder();
//         for (String roomName : roomNames) {
//             sb.append("Room ").append(roomName).append(":").append("\n");
//             // Q. Map.Entry<Integer, Integer> 키 값 기준으로 오름 차순 정렬하는 방법 A. HashMap 대신 TreeMap 사용(자동 정렬)
//             // Q. 이 문장에서 Exception in thread "main" java.lang.NullPointerException 발생 이유?
//             // A. 아예 room 예약 없는 room이 있음 ex) aerocity
//             // room은 있으나 예약이 없는 경우
//             if (rooms.get(roomName) == null) {
//                 sb.append("1 available:").append("\n");
//                 sb.append("09-18").append("\n");
//                 if (roomNames.indexOf(roomName) != roomNames.size()-1) sb.append("-----").append("\n");
//                 continue;
//             }
//             Map<Integer, Integer> roomTimes = new TreeMap<>(rooms.get(roomName));
//             // System.out.println("roomTimes: "+roomTimes);
//             // System.out.println("rooms: "+rooms.get(roomName));
            
//             // 4. 남는 예약 시간 체크 (핵심 로직)
//             // Q. roomTimes 원소에 접근하는 방법?  A. keySet(), entrySet()
//             int cnt = 0;  // 사용 가능한 room 체크 횟수; cnt=0 이면 "Not available"
//             int lastEnd = 9;
//             ArrayList<String> availableRooms = new ArrayList<>();
//             ArrayList<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(roomTimes.entrySet());
//             // for (Map.Entry<Integer, Integer> entry : roomTimes.entrySet()) {
//             for (int i=0; i<entryList.size(); i++) {
//                 Map.Entry<Integer, Integer> entry = entryList.get(i);
//                 int currentStart = entry.getKey();
//                 if (currentStart - lastEnd > 0) {
//                     // Q. 한 자리 수(9) 일 경우, 앞 공백에 0 채워넣는 방법?  A. String.format("%02d")
//                     String formattedLastEnd = String.format("%02d", lastEnd);
//                     // Q. integer를 String으로 다른 문자와 함께 ArrayList에 저장하는 방법?  A. String.valueOf
//                     availableRooms.add(formattedLastEnd + "-" + String.valueOf(currentStart));
//                     cnt++;
//                 }
//                 lastEnd = entry.getValue();  // 직전 원소 종료 시간 업데이트
//                 // Q. 마지막 원소인 경우 체크 방법?  A. Map을 ArrayList로 변환 > 인덱스 체크 가능한 for 문 돌기
//                 if (i == entryList.size()-1 && 18 - lastEnd >0) {
//                     availableRooms.add(String.valueOf(lastEnd) + "-" + String.valueOf(18));
//                     cnt++;
//                 }
//                 // System.out.println("시작시간: "+entry.getKey());
//                 // System.out.println("종료시간: "+entry.getValue()); 
//             }
//             if (cnt==0) sb.append("Not available").append("\n");
//             else {
//                 sb.append(cnt).append(" available:").append("\n");
//                 for (String room : availableRooms) sb.append(room).append("\n");
//             }
//             // Q. for (String roomName : roomNames) { 이렇게 반복문 도는 경우 마지막 원소임을 체크하는 방법?
//             // A. roomNames.indexOf(roomName) != roomNames.size()-1
//             if (roomNames.indexOf(roomName) != roomNames.size()-1) sb.append("-----").append("\n");
//         }
//         System.out.print(sb);
//         // Q. 아래 코드를 실행했을 때 각 원소에 접근하지 못 해 콘솔에 아무 것도 출력되지 않는 이유?
//         // for (int i=0; i<n; i++) {
//         //     System.out.println(roomNames.get(i));
//         //     // System.out.println("rooms: "+ rooms.get(roomNames.get(i)));
//         // }
        
//     }
// }














