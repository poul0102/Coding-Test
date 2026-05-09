package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/176962
public class P176962 {
	public String[] solution(String[][] plans) {
		List<String> answer = new ArrayList<>();

		// 시간을 분 단위로 변환
		for (String[] plan : plans) {
			plan[1] = String.valueOf(toMinute(plan[1]));
		}

		// 시작 시간을 기준으로 정렬
		Arrays.sort(plans, (a, b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));

		// [과목명, 남은시간]
		Stack<String[]> stack = new Stack<>();

		for (int i = 0; i < plans.length - 1; i++) {
			String name = plans[i][0]; // 과제명
			int start = Integer.parseInt(plans[i][1]); // 시작 시간
			int time = Integer.parseInt(plans[i][2]); // 소요 시간
			int end = start + time; // 끝나는 시간
			int nextStart = Integer.parseInt(plans[i + 1][1]); // 다음 과제의 시작 시간

			// 현재 과제를 다음 과제 시작 전까지 끝낼 수 있는 경우
			if (end <= nextStart) {
				answer.add(name);
				int remain = nextStart - end; // 다음 과제까지 남은 시간

				// 멈춘 과제 재개
				while (!stack.isEmpty() && remain > 0) {
					String[] stop = stack.pop();

					String stopName = stop[0]; // 멈춘 과제명
					int stopTime = Integer.parseInt(stop[1]); // 멈춘 과제의 남은 시간

					// 남은 시간 내에 끝낼 수 있는 경우
					if (stopTime <= remain) {
						answer.add(stopName);
						remain -= stopTime;
					} else {
						// 일부 진행 후 스택에 다시 저장
						stopTime -= remain;
						stack.push(new String[] { stopName, String.valueOf(stopTime) });
						remain = 0;
					}
				}
			} else {
				// 현재 과제를 다 못 끝내는 경우
				int remain = end - nextStart;
				stack.push(new String[] { name, String.valueOf(remain) });
			}
		}

		// 마지막 과제 처리
		answer.add(plans[plans.length - 1][0]);

		// 남아있는 과제 처리
		while (!stack.isEmpty()) {
			answer.add(stack.pop()[0]);
		}

		return answer.toArray(new String[0]);
	}

	// 분 단위 변환 함수
	public int toMinute(String time) {
		String[] arr = time.split(":");

		int hour = Integer.parseInt(arr[0]);
		int minute = Integer.parseInt(arr[1]);

		return hour * 60 + minute;
	}
}
