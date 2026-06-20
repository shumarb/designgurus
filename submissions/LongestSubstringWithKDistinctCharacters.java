// Question: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/longest-substring-with-k-distinct-characters-medium

import java.util.*;

class LongestSubstringWithKDistinctCharacters {
    public int findLength(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] letters = str.toCharArray();
        int currentLength = 0;
        int left = 0;
        int result = 0;

        for (int right = 0; right < letters.length; right++) {
            char incoming = letters[right];

            map.put(incoming, 1 + map.getOrDefault(incoming, 0));
            currentLength++;

            while (map.size() > k) {
                char remove = letters[left++];

                map.put(remove, map.get(remove) - 1);
                if (map.get(remove) == 0) {
                    map.remove(remove);
                }

                currentLength--;
            }

            result = Math.max(currentLength, result);
        }

        return result;
    }
}
