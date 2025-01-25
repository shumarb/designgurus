public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        boolean isTest = false;

        int[] prefixSumArr = new int[gain.length];
        prefixSumArr[0] = gain[0];
        for (int i = 1; i < gain.length; i++) {
            prefixSumArr[i] = gain[i] + prefixSumArr[i - 1];
        }
        if (isTest) {
            System.out.println("gain: " + Arrays.toString(gain));
            System.out.println("prefixSumArr: " + Arrays.toString(prefixSumArr));
        }
        int maxAltitude = prefixSumArr[0];
        for (int prefixSum: prefixSumArr) {
            maxAltitude = Math.max(maxAltitude, prefixSum);
        }
        return maxAltitude < 0 ? 0 : maxAltitude;
    }
}
