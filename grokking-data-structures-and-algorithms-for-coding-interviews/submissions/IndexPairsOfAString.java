// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/index-pairs-of-a-string-easy

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// class TrieNode {
//     TrieNode[] children = new TrieNode[26]; // Array to hold child nodes for each letter
//     boolean isEnd = false; // Flag to mark the end of a word
// }

public class IndexPairsOfAString {
    public List<List<Integer>> indexPairs(String text, List<String> words) {
        List<List<Integer>> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        boolean isTest = false;

        for (String word : words) {
            int wordLength = word.length();
            for (int i = 0; i <= text.length() - wordLength; i++) {
                String substring = text.substring(i, i + wordLength);
                if (word.equals(substring)) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(i + wordLength - 1);
                    result.add(pair);
                }
            }
        }

        // 1. Sort entries by ascending order of start index, followed by end index.
        result.sort(
                (a, b) -> Integer.compare(a.get(0), b.get(0)) == 0 ? Integer.compare(a.get(1), b.get(1)) : Integer.compare(a.get(0), b.get(0))
        );
        if (isTest) {
            System.out.println("result:");
            for (List<Integer> entry: result) {
                System.out.println(" * " + entry);
            }
            System.out.println("-------------------------------------------");
        }

        return result;
    }
}