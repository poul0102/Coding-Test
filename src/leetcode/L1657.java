package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75
public class L1657 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(sol.closeStrings("abc", "bca"));
		System.out.println(sol.closeStrings("a", "aa"));
		System.out.println(sol.closeStrings("cabbba", "abbccc"));
	}

	static class Solution {
		public boolean closeStrings(String word1, String word2) {
			/*
			 * 사용된 문자 집합이 같다.
			 * 문자 빈도의 멀티셋이 같다.
			 * 위 두 조건이 모두 만족해야 한다.
			 */

			if (word1.length() != word2.length())
				return false;

			int[] w1 = new int[26];
			int[] w2 = new int[26];

			// 각 문자 빈도 세기
			for (int i = 0; i < word1.length(); i++) {
				w1[word1.charAt(i) - 'a']++;
				w2[word2.charAt(i) - 'a']++;
			}

			// 각 문자 존재 여부 확인
			for (int i = 0; i < 26; i++) {
				if ((w1[i] == 0) != (w2[i] == 0))
					return false;
			}

			// 빈도의 멀티셋 동일 여부 확인
			Arrays.sort(w1);
			Arrays.sort(w2);

			return Arrays.equals(w1, w2);
		}
	}

}
