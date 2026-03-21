package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/17677
public class P17677 {
	public int solution(String str1, String str2) {
		int answer = 0;

		// 대소문자 구분 X
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();

		// 다중집합의 원소 저장
		List<String> s1 = new ArrayList<>();
		List<String> s2 = new ArrayList<>();

		// 다중집합의 원소 생성
		for (int i = 0; i < str1.length() - 1; i++) {
			char c1 = str1.charAt(i);
			char c2 = str1.charAt(i + 1);
			if (c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z') {
				s1.add("" + c1 + c2);
			}
		}

		for (int i = 0; i < str2.length() - 1; i++) {
			char c1 = str2.charAt(i);
			char c2 = str2.charAt(i + 1);
			if (c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z') {
				s2.add("" + c1 + c2);
			}
		}

		int and = 0; // 교집합
		int or = 0; // 합집합

		// 교집합 확인을 위한 리스트
		List<String> temp = new ArrayList<>(s1);

		for (String s : s2) {
			if (temp.contains(s)) {
				and++;
				temp.remove(s);
			}
		}

		or = s1.size() + s2.size() - and;

		if (or == 0) {
			answer = 65536;
		} else {
			answer = 65536 * and / or;
		}

		return answer;
	}
}
