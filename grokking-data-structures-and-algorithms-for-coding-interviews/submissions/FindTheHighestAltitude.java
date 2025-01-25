public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        public int largestAltitude(int[] gain) {
            int maxAltitude = 0;
            int cumulativeAltitude = 0;
            for (int i = 0; i < gain.length; i++) {
                cumulativeAltitude += gain[i];
                maxAltitude = Math.max(maxAltitude, cumulativeAltitude);
            }
            return maxAltitude;
        }
    }
}
