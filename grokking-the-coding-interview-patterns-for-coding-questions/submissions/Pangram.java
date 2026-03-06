// Question: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/pangram-easy

class Pangram {
    public boolean checkIfPangram(String sentence) {
        boolean[] isPresent = new boolean[52];
        boolean isTest = false;

        for (char c: sentence.toCharArray()) {
            if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
                char upper = Character.toUpperCase(c);
                char lower = Character.toLowerCase(c);
                isPresent[upper - 'A'] = true;
                isPresent[lower - 'a' + 26] = true;
            }
        }
        if (isTest) {
            System.out.println("isPresent: " + Arrays.toString(isPresent));
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (!isPresent[c - 'a' + 26] || !isPresent[Character.toUpperCase(c) - 'A']) {
                return false;
            }
        }
        return true;
    }
}
