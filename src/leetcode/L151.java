package leetcode;

import java.util.*;

// https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75
public class L151 {

	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(sol.reverseWords("the sky is blue"));

		System.out.println(sol.reverseWords("  hello world  "));

		System.out.println(sol.reverseWords("a good   example"));
	}

	static class Solution {
		public String reverseWords(String s) {
			StringBuilder answer = new StringBuilder();

			StringTokenizer st = new StringTokenizer(s);

			while (st.hasMoreTokens()) {	// 토큰이 있다면
				answer.insert(0, st.nextToken() + " ");	// answer의 맨 앞에 토큰 추가
			}

			return answer.toString().trim();	// 마지막 단어에 추가된 공백을 지우기 위해 trim() 사용
		}
	}

}
