// Question:

import java.util.*;

public class PalindromeCheckUsingQueue {
    public static boolean checkPalindrome(String s) {
        Queue<Character> firstQueue = new LinkedList<>();
        Queue<Character> secondQueue = new LinkedList<>();
        boolean isTest = false;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isLetter(currentChar)) {
                firstQueue.offer(Character.toLowerCase(currentChar));
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            if (Character.isLetter(currentChar)) {
                secondQueue.offer(Character.toLowerCase(currentChar));
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\nfirstQueue: " + firstQueue + "\nsecondQueue: " + secondQueue);
        }

        if ((firstQueue.isEmpty() && secondQueue.isEmpty()) || (firstQueue.size() != secondQueue.size())) {
            return false;
        }

        while (!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
            if (isTest) {
                System.out.println("checking | first: " + firstQueue.peek() + ", second: " + secondQueue.peek());
            }
            if (firstQueue.poll() != secondQueue.poll()) {
                return false;
            }
        }

        return true;
    }
}
