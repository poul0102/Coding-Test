package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/148653
public class P148653 {
	
	public int solution(int storey) {
		int answer = 0;
		
		while (storey > 0) {
			int cur = storey % 10;			// 현재 자릿수
			int next = (storey / 10) % 10;	// 다음 자릿수
			
			// cur이 6 ~ 9인 경우
			if (cur > 5) {
				answer += 10 - cur;	// 위로 올리는 비용
				storey += 10 - cur;	// 위로 올리기
			} 
			// cur이 0 ~ 4인 경우
			else if (cur < 5) {
				answer += cur;	// 아래로 내리는 비용
				// 아래로 내리는 경우는 계산하지 않아도 됨 (storey /= 10을 통해 끝자리가 버려지기 때문)
			}
			// cur이 5인 경우 다음 자릿수에 따라 판단
			else {
				if (next >= 5) {
					answer += 10 - cur;
					storey += 10 - cur;
				} else {
					answer += cur;
				}
			}
			
			storey /= 10;
		}
		
		return answer;
	}
}
