// Question: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/shortest-word-distance-easy

class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int shortestDistance = Integer.MAX_VALUE;
        int lastWord1Index = -1;
        int lastWord2Index = -1;

        for (int i = 0; i < words.length; i++) {
            String current = words[i];
            if (current.equals(word1)) {
                lastWord1Index = i;
            }

            if (current.equals(word2)) {
                lastWord2Index = i;
            }

            if (lastWord1Index != -1 && lastWord2Index != -1) {
                int currentDistance = Math.abs(lastWord2Index - lastWord1Index);
                shortestDistance = Math.min(currentDistance, shortestDistance);
            }
        }

        return shortestDistance;
    }
}
