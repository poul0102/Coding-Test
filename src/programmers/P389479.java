package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/389479
public class P389479 {
	public int solution(int[] players, int m, int k) {
		int answer = 0;
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < players.length; i++) {
			
			// 서버 반납 시간 확인
			while (!q.isEmpty() && q.peek() + k == i) {
				q.poll();
			}
			
			int need = players[i] / m;
			
			// 보유한 서버보다 필요한 서버가 많을 경우
			if (need > q.size()) {
				int add = need - q.size();
				answer += add;
				
				// 증설한 서버 수 만큼 Queue에 추가
				for (int j = 0; j < add; j++) {
					q.offer(i);
				}
			}
		}
		
		return answer;
	}
}
