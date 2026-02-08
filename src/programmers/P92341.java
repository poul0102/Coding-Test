package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/92341
public class P92341 {
	
	StringTokenizer st;
	
	public int[] solution(int[] fees, String[] records) {
    
		// 차량 번호별 누적 주차 시간 저장
        Map<String, Integer> timeMap = new HashMap<>();
        
        for (String record : records) {
        	st = new StringTokenizer(record);
        	String timeStr = st.nextToken();
        	String carNum = st.nextToken();
        	String type = st.nextToken();
        	
        	// 시간을 분 단위로 변환
        	int time = toMinutes(timeStr);
        	
        	// IN이면 -time, OUT이면 +time
        	timeMap.put(carNum, timeMap.getOrDefault(carNum, 0) + (type.equals("IN") ? -time : time));
        }
        
        // 차량 번호 오름차순 정렬
        List<String> sorted = new ArrayList<>(timeMap.keySet());
        Collections.sort(sorted);
        
        int end = toMinutes("23:59");
        
        int[] answer = new int[sorted.size()];
        
        for (int i = 0; i < sorted.size(); i++) {
        	String carNum = sorted.get(i);
        	int time = timeMap.get(carNum);
        	
        	// 출차 되지 않은 차량 계산
        	if (time < 1) {
        		time = time + end;
        	}
        	
        	// 기본 시간인 경우
        	if (time <= fees[0]) {
        		answer[i] = fees[1];
        	}
        	// 기본 시간 초과인 경우
        	else {
        		answer[i] = fees[1] + (((int)Math.ceil((double)(time - fees[0]) / fees[2])) * fees[3]);
        	}
        }
        
        return answer;
    }
	
	int toMinutes(String timeStr) {
		st = new StringTokenizer(timeStr, ":");
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		return hour * 60 + minute;
	}
}
