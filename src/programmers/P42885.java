package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42885
public class P42885 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(sol.solution(new int[] { 70, 50, 80, 50 }, 100));
		System.out.println(sol.solution(new int[] { 70, 80, 50 }, 100));
	}

	static class Solution {
		public int solution(int[] people, int limit) {
			int answer = 0;

			// 몸무게를 오름차순으로 정렬
			Arrays.sort(people);

			// 가장 가벼운 사람과 가장 무거운 사람을 가리키는 투 포인터
			int light = 0;
			int heavy = people.length - 1;

			// 모든 사람이 보트에 탈 때까지 반복
			while (light <= heavy) {
				// 가벼운 사람과 무거운 사람을 함께 태울 수 있는 경우
				if (people[light] + people[heavy] <= limit) {
					light++;
				}

				// 가벼운 사람과 함께 탈 수 없다면 혼자 탑승해야 하므로 항상 감소
				heavy--;
				answer++;
			}

			return answer;
		}
	}

}
