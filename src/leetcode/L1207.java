package leetcode;

import java.util.*;

// https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75
public class L1207 {

	// 실행 예시
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		System.out.println(sol.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(sol.uniqueOccurrences(new int[]{1,2}));
        System.out.println(sol.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
	}

	static class Solution {
		public boolean uniqueOccurrences(int[] arr) {

			Map<Integer, Integer> map = new HashMap<>();
			for (int x : arr) {
				// 방법 1
//				// map에 x값이 존재한다면
//				if (map.containsKey(x)) {
//					map.put(x, map.get(x) + 1); // 기존 갯수에 +1
//				} else {
//					map.put(x, 1); // 초기값 1로 설정
//				}
				
				// 방법 2
				// getOrDefault : 찾는 키가 존재한다면 값을 반환하고 없다면 기본 값을 반환
				map.put(x, map.getOrDefault(x, 0) + 1);
			}

			Set<Integer> set = new HashSet<>();
			for (int count : map.values()) {
				if (!set.add(count)) {
					return false;
				}
			}

			return true;
		}
	}
}
